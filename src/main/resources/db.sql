DROP DATABASE IF EXISTS ssafit;
CREATE DATABASE ssafit;
USE ssafit;

-- users 테이블 생성
CREATE TABLE users (
	user_id INT PRIMARY KEY AUTO_INCREMENT,
    id VARCHAR(45) NOT NULL UNIQUE,
    password VARCHAR(45) NOT NULL,
    name VARCHAR(16) NOT NULL,
    email VARCHAR(255) NOT NULL,
    status INT NOT NULL DEFAULT 1,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- videos 테이블 생성
CREATE TABLE videos (
    video_id     VARCHAR(45)  PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    part         VARCHAR(45),
    channel_name VARCHAR(45)  NOT NULL,
    url          TEXT         NOT NULL,
    thumbnail    TEXT,
    view_count   INT          NOT NULL DEFAULT 0,
    status       INT          DEFAULT 1
);

-- reviews 테이블 생성
CREATE TABLE reviews (
    review_id       INT          PRIMARY KEY AUTO_INCREMENT,
    video_id        VARCHAR(45)  NOT NULL,
    user_id         INT          NOT NULL,
    content         TEXT         NOT NULL,
    parent_review_id INT          NOT NULL DEFAULT 0,
    created_at      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_at     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (video_id) REFERENCES videos(video_id),
    FOREIGN KEY (parent_review_id) REFERENCES reviews(review_id)
);

-- favorites 테이블 생성
CREATE TABLE favorites (
    user_id    INT          NOT NULL,
    video_id   VARCHAR(45)  NOT NULL,
    updated_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, video_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (video_id) REFERENCES videos(video_id)
);

-- video.json 내용 추가
INSERT INTO videos (video_id, title, part, channel_name, url, thumbnail, view_count, status) VALUES
('50WCSpZtdmA', 'Shim EuDdeum 10 Minute Morning Stretch Everydayㅣ2023 Renewal', '전신', '힘으뜸', 'https://www.youtube.com/watch?v=50WCSpZtdmA', 'https://img.youtube.com/vi/50WCSpZtdmA/maxresdefault.jpg', 0, 1),
('Kk7TQGqQ3nA', '하루 두 번🧘🏻‍♀️반드시 해야하는 20분 전신순환 스트레칭 Ep.08 - 피로회복, 디톡스, 심신안정, 혈액순환, 라인정리 효과 (Whole body stretch)', '전신', '빵느', 'https://www.youtube.com/watch?v=Kk7TQGqQ3nA', 'https://img.youtube.com/vi/Kk7TQGqQ3nA/maxresdefault.jpg', 0, 1),
('MTU4iCDntjs', '4 Minute OFFICE STRETCHING(full body)', '전신', 'Allblanc TV', 'https://www.youtube.com/watch?v=MTU4iCDntjs', 'https://img.youtube.com/vi/MTU4iCDntjs/maxresdefault.jpg', 0, 1),
('D3yExRi7EME', '뭉친 어깨, 뻣뻣한 골반 풀어주는 요가 | 앉아서 하는 요가 스트레칭 | 어깨 근육 풀기, 골반풀기', '상체', 'Mindful Yoga with Eileen', 'https://www.youtube.com/watch?v=D3yExRi7EME', 'https://img.youtube.com/vi/D3yExRi7EME/maxresdefault.jpg', 0, 1),
('02K-k6daPb4', '15 MIN Fat Burning Cardio - 서서하는 유산소 - 다이어트 운동', '전신', '빅씨스 Bigsis', 'https://www.youtube.com/watch?v=02K-k6daPb4', 'https://img.youtube.com/vi/02K-k6daPb4/maxresdefault.jpg', 0, 1),
('gMaB-fG4u4g', '전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]', '전신', 'ThankyouBUBU', 'https://www.youtube.com/embed/gMaB-fG4u4g', 'https://img.youtube.com/vi/gMaB-fG4u4g/maxresdefault.jpg', 0, 1),
('swRNeYw1JkY', '하루 15분! 전신 칼로리 불태우는 다이어트 운동', '전신', 'ThankyouBUBU', 'https://www.youtube.com/embed/swRNeYw1JkY', 'https://img.youtube.com/vi/swRNeYw1JkY/maxresdefault.jpg', 0, 1),
('54tTYO-vU2E', '상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]', '상체', 'ThankyouBUBU', 'https://www.youtube.com/embed/54tTYO-vU2E', 'https://img.youtube.com/vi/54tTYO-vU2E/maxresdefault.jpg', 0, 1),
('QqqZH3j_vH0', '상체비만 다이어트 최고의 운동 [상체 핵매운맛]', '상체', 'ThankyouBUBU', 'https://www.youtube.com/embed/QqqZH3j_vH0', 'https://img.youtube.com/vi/QqqZH3j_vH0/maxresdefault.jpg', 0, 1),
('tzN6ypk6Sps', '하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]', '하체', '김강민', 'https://www.youtube.com/embed/tzN6ypk6Sps', 'https://img.youtube.com/vi/tzN6ypk6Sps/maxresdefault.jpg', 0, 1),
('u5OgcZdNbMo', '저는 하체 식주의자 입니다', '하체', 'GYM종국', 'https://www.youtube.com/embed/u5OgcZdNbMo', 'https://img.youtube.com/vi/u5OgcZdNbMo/maxresdefault.jpg', 0, 1),
('PjGcOP-TQPE', '11자복근 복부 최고의 운동 [복근 핵매운맛]', '복부', 'ThankyouBUBU', 'https://www.youtube.com/embed/PjGcOP-TQPE', 'https://img.youtube.com/vi/PjGcOP-TQPE/maxresdefault.jpg', 0, 1),
('7TLk7pscICk', '(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)', '복부', 'SomiFit', 'https://www.youtube.com/embed/7TLk7pscICk', 'https://img.youtube.com/vi/7TLk7pscICk/maxresdefault.jpg', 0, 1);

-- users 데이터 추가
INSERT INTO users (id, password, name, email, status) VALUES
('ssafy', 'ssafy1234', '김싸피', 'ssafy@ssafy.com', 1),
('hong', 'hong1234', '홍길동', 'hong@gmail.com', 1),
('admin', 'admin1234', '관리자', 'admin@ssafit.com', 1);

SELECT * FROM videos;
SELECT * FROM users;