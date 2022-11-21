CREATE TABLE GRADE(
                      USER_ID VARCHAR(40) NOT NULL,
                      GRADE VARCHAR(40) NOT NULL,
                      MINIMUM_SPENT_MONEY INT NOT NULL,
                      MINIMUM_PURCHASE_COUNT INT NOT NULL,
                      PRIMARY KEY (GRADE),
                      FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
);
INSERT INTO GRADE VALUES ('a','General',0,0);
INSERT INTO GRADE VALUES ('a','VIP',100000,3);
INSERT INTO GRADE VALUES ('a','VVIP',300000,10);
INSERT INTO GRADE VALUES ('b','일반',0,0);
INSERT INTO GRADE VALUES ('b','고급',100000,3);
INSERT INTO GRADE VALUES ('b','최고급',300000,10);
INSERT INTO GRADE VALUES ('b','럭셔리',500000,15);

SELECT * FROM GRADE;
//        UPDATE 테이블이름 SET 컬럼명=컬럼값, ... WHERE 조건;
//        DELETE FROM 테이블이름 WHERE 조건;
DROP TABLE GRADE;




