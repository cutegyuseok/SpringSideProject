CREATE TABLE USERS(
                      USER_ID VARCHAR(20) NOT NULL,
                      GRADE VARCHAR(20) NOT NULL,
                      MINIMUM_SPENT_MONEY INT NOT NULL,
                      MINIMUM_PURCHASE_COUNT INT NOT NULL,
                      PRIMARY KEY (GRADE),
                      FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
);