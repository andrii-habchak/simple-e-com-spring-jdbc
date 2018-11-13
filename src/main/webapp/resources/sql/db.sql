CREATE TABLE ROLE (
  NAME VARCHAR(10) PRIMARY KEY
);

CREATE TABLE USER_TO_ROLE (
  FK_USER_ID BIGINT NOT NULL,
  FK_ROLE_ID VARCHAR (10) NOT NULL,
  PRIMARY KEY (FK_USER_ID, FK_ROLE_ID),
  CONSTRAINT FK_UTR_USERS FOREIGN KEY (FK_USER_ID)
  REFERENCES USERS(ID),
  CONSTRAINT FK_UTR_ROLES FOREIGN KEY (FK_ROLE_ID)
  REFERENCES ROLE(NAME)
);

CREATE TABLE ORDERS
(
    ORDER_ID LONG AUTO_INCREMENT PRIMARY KEY NOT NULL,
    CUSTOMER_ID LONG NOT NULL,
    ORDER_DATE DATE,
    ORDER_AMOUNT DOUBLE NOT NULL,
    ORDER_COMMENT TEXT
);

CREATE TABLE ORDER_TO_PRODUCT (
  FK_ORDER_ID      LONG NOT NULL,
  FK_PRODUCT_ID    LONG NOT NULL,
  PRODUCT_QUANTITY INT  NOT NULL,
  PRIMARY KEY (FK_ORDER_ID, FK_PRODUCT_ID),
  CONSTRAINT ORDERS FOREIGN KEY (FK_ORDER_ID) REFERENCES ORDERS (ORDER_ID),
  CONSTRAINT PRODUCTS FOREIGN KEY (FK_PRODUCT_ID) REFERENCES PRODUCTS (ID)
);