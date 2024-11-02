# SSAFIT 프로젝트 회고록

## 1. 프로젝트 개요

이번 관통 프로젝트는 Spring Boot를 활용하여 이전에 설계한 SSAFIT의 데이터베이스를 기반으로 REST API를 구현하는 것이었습니다. 기존 프로젝트의 연장선상에서 진행되어 팀원들과 빠르게 업무를 분담하고 구현을 시작할 수 있었습니다.

### 담당 업무

- 초기 데이터베이스 DDL 설정
- 영화 조회 관련 API 구현
    - `/api/videos/most-viewed`
    - `/api/videos/search/{part}`

## 2. 협업 프로세스

Git Flow 전략을 기반으로 체계적인 브랜치 관리를 진행했습니다:

```
main
└── dev
    └── feature/[기능명]
```

개별 기능 구현 완료 후 dev 브랜치로 머지하는 방식으로 진행했습니다.

## 3. 주요 구현 내용

1. 데이터베이스 구조 최적화
    - 팀원들과 테이블 구조 검토 및 개선
    - reviews 테이블의 parent 필드를 parent_review_id로 변경
    - 대댓글 구현을 위한 셀프 참조 외래키 제약조건 추가
2. REST API 개발 (VideoRestController)
    - 조회수 기준 영상 목록 조회 (`/api/videos/most-viewed`)
    - 검색어 기반 영상 검색 (`/api/videos/search/{part}`)
    - 결과 개수 제한 파라미터 구현

### API 명세서

### 1. 조회수 기준 영상 목록 조회

### 전체 영상 조회

- **URL**: `/api/videos/most-viewed`
- **Method**: `GET`
- **Description**: 조회수 기준으로 정렬된 전체 영상 목록을 반환
- **Response**:
    - Success (200 OK):
        
        ```json
        [
          {
            "videoId": "string",
            "title": "string",
            "part": "string",
            "channelName": "string",
            "viewCnt": "integer"
          }
        ]
        ```
        
    - No Content (204): 영상이 없는 경우

### 상위 N개 영상 조회

- **URL**: `/api/videos/most-viewed/{count}`
- **Method**: `GET`
- **Parameters**:
    - `count` (path parameter): 조회할 영상 개수
- **Description**: 조회수 기준으로 상위 N개의 영상 목록을 반환
- **Response**: 위와 동일

### 2. 운동 부위별 영상 검색

### 부위별 전체 영상 조회

- **URL**: `/api/videos/search/{part}`
- **Method**: `GET`
- **Parameters**:
    - `part` (path parameter): 운동 부위 (예: 전신, 상체, 하체 등)
- **Description**: 특정 운동 부위에 해당하는 전체 영상 목록을 반환
- **Response**: 위와 동일

### 부위별 상위 N개 영상 조회

- **URL**: `/api/videos/search/{part}/{count}`
- **Method**: `GET`
- **Parameters**:
    - `part` (path parameter): 운동 부위
    - `count` (path parameter): 조회할 영상 개수
- **Description**: 특정 운동 부위의 영상 중 상위 N개 목록을 반환
- **Response**: 위와 동일

## 4. 새롭게 알게 된 점

프로젝트를 진행하면서 데이터베이스 설계와 REST API 구현에 대한 여러 기술적 인사이트를 얻을 수 있었습니다.

### 대댓글 구현시 데이터베이스 설계

대댓글 기능 구현을 위해 reviews 테이블에 parent_review_id 필드를 추가했습니다. 처음에는 일반 댓글의 경우 default 값을 0으로 설정했으나, 실제 구현 과정에서 셀프 조인 시 데이터베이스 무결성 문제가 발생했습니다. 이를 해결하기 위해 parent_review_id에 NULL을 허용하고 reviews 테이블의 review_id를 참조하는 외래키로 설정하여 데이터 일관성을 확보할 수 있었습니다.

### REST API 엔드포인트 설계

처음에는 count가 null이면 전체 선택이 되게끔 엔드포인트를 설계해서 중복되는 메서드를 만들지 않으려고 했는데 구현 당시에는 오류가 나서 안되는 줄 알았습니다.

하지만 나중에 선택적 경로 변수를 사용해서 하나의 컨트롤러 메서드로 처리할 수 있음을 알게 되었습니다. 그리고 int로 하면 count가 null exception error가 나서 Integer를 해주는게 좋다는 것도 알게 되었습니다.

```java
@GetMapping({"/most-viewed", "/most-viewed/{count}"})
public ResponseEntity<List<Video>> getTopViewedVideos(@PathVariable(required = false) Integer count) {
    List<Video> videos = vs.getTopViewedVideos(count);
    if (videos == null || videos.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(videos, HttpStatus.OK);
}
```

이러한 과정을 통해 Spring MVC에서 선택적 경로 변수를 활용한 효율적인 API 설계 방법과 기본 타입과 래퍼 클래스의 차이점에 대해 실제적으로 이해할 수 있었습니다.

```java
자바에서 기본 타입(Primitive Type)과 래퍼 클래스(Wrapper Class)의 주요 차이점

1. null 처리
- 기본 타입(int, double 등): null을 가질 수 없음
- 래퍼 클래스(Integer, Double 등): null 가질 수 있음

2. 메모리
- 기본 타입: 스택 메모리에 직접 값 저장
- 래퍼 클래스: 힙 메모리에 객체로 저장

3. 기본값
- 기본 타입: 자동으로 초기화 (int → 0, boolean → false)
- 래퍼 클래스: 초기화하지 않으면 null
```

예시:

```java
// 기본 타입
int count = null;  // 컴파일 에러
int defaultInt;    // 0으로 초기화

// 래퍼 클래스
Integer count = null;  // 정상 동작
Integer defaultInteger;  // null로 초기화
```
