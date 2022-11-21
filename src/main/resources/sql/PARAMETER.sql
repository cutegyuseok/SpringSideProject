CREATE TABLE PARAMETER(
                      USER_ID VARCHAR(40) NOT NULL,
                      GRADE VARCHAR(40) NOT NULL,
                      MINIMUM_SPENT_MONEY INT NOT NULL,
                      MINIMUM_PURCHASE_COUNT INT NOT NULL,
                      FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
);
INSERT INTO PARAMETER VALUES ('a','General',0,0);
INSERT INTO PARAMETER VALUES ('a','VIP',100000,3);
INSERT INTO PARAMETER VALUES ('a','VVIP',300000,10);
INSERT INTO PARAMETER VALUES ('b','Grade1',0,0);
INSERT INTO PARAMETER VALUES ('b','Grade2',100000,3);
INSERT INTO PARAMETER VALUES ('b','Grade3',300000,10);
INSERT INTO PARAMETER VALUES ('b','Grade4',500000,15);

SELECT * FROM PARAMETER;
//        UPDATE 테이블이름 SET 컬럼명=컬럼값, ... WHERE 조건;
//        DELETE FROM 테이블이름 WHERE 조건;
DROP TABLE PARAMETER;





