# PJT-6 README

- 테이블 종류
  - user
  - video
  - review
  - favorite (찜 기능)

### `user` Table

| Column Name | Data Type    | Constraints                           | 비고                                              |
| ----------- | ------------ | ------------------------------------- | ------------------------------------------------- |
| user_id     | INT          | NOT NULL, AUTO_INCREMENT, PRIMARY KEY |                                                   |
| id          | VARCHAR(45)  | NOT NULL, UNIQUE                      |                                                   |
| password    | VARCHAR(45)  | NOT NULL                              |                                                   |
| name        | VARCHAR(16)  | NOT NULL                              |                                                   |
| email       | VARCHAR(255) | NOT NULL                              |                                                   |
| status      | INT          | NOT NULL, DEFAULT 1                   | 0: 탈퇴, 1: 일반 회원, 2: 휴면 회원, 3: 정지 회원 |
| created_at  | TIMESTAMP    | NOT NULL, DEFAULT CURRENT_TIMESTAMP   |                                                   |

### `video` Table

| Column Name  | Data Type    | Constraints                   | 비고                                           |
| ------------ | ------------ | ----------------------------- | ---------------------------------------------- |
| video_id     | VARCHAR(45)  | NOT NULL, PRIMARY KEY, UNIQUE |                                                |
| title        | VARCHAR(255) | NOT NULL                      |                                                |
| part         | VARCHAR(45)  | NULL                          |                                                |
| channel_name | VARCHAR(45)  | NOT NULL                      |                                                |
| url          | TEXT         | NOT NULL                      |                                                |
| thumbnail    | TEXT         | NULL                          |                                                |
| views        | INT          | NOT NULL, DEFAULT 0           |                                                |
| status       | INT          | NULL, DEFAULT 1               | 0: 삭제, 1: 전체 공개, 2: 비공개, 3: 일부 공개 |

### `review` Table

| Column Name    | Data Type    | Constraints                                                     | 비고                                                 |
| -------------- | ------------ | --------------------------------------------------------------- | ---------------------------------------------------- |
| review_id      | INT          | NOT NULL, AUTO_INCREMENT, PRIMARY KEY, UNIQUE                   |                                                      |
| video_id       | VARCHAR(255) | NOT NULL                                                        |                                                      |
| user_id        | VARCHAR(45)  | NOT NULL                                                        |                                                      |
| content        | TEXT         | NOT NULL                                                        |                                                      |
| parent         | INT ZEROFILL | NOT NULL                                                        | 0: 기본 댓글, review_id: 대댓글을 위한 원댓글 아이디 |
| created_at     | TIMESTAMP    | NOT NULL, DEFAULT CURRENT_TIMESTAMP                             |                                                      |
| modified_at    | TIMESTAMP    | NOT NULL, DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP |                                                      |
| user_user_id   | INT          | NOT NULL, FOREIGN KEY REFERENCES `user`(`user_id`)              |                                                      |
| video_video_id | VARCHAR(45)  | NOT NULL, FOREIGN KEY REFERENCES `video`(`video_id`)            |                                                      |

### `favorite` Table

| Column Name    | Data Type   | Constraints                                          |
| -------------- | ----------- | ---------------------------------------------------- |
| user_id        | INT         | NOT NULL, PRIMARY KEY                                |
| video_id       | VARCHAR(45) | NOT NULL, PRIMARY KEY                                |
| updated_at     | TIMESTAMP   | NOT NULL, DEFAULT CURRENT_TIMESTAMP                  |
| user_user_id   | INT         | NOT NULL, FOREIGN KEY REFERENCES `user`(`user_id`)   |
| video_video_id | VARCHAR(45) | NOT NULL, FOREIGN KEY REFERENCES `video`(`video_id`) |

- 관계
  - user와 review - 1:N의 강한 관계
  - video와 review - 1:N의 강한 관계
  - user와 favorite - 1:N의 강한 관계
  - video와 favorite - 1:N의 강한 관계
