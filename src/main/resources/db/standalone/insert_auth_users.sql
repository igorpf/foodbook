
------------ AUTHORITIES ------------
INSERT INTO AUTHORITY(ID, NAME) VALUES (1, 'ADMIN');
INSERT INTO AUTHORITY(ID, NAME) VALUES (2, 'NORMAL_USER');
------------ AUTHORITIES ------------

------------ USER ------------
INSERT INTO USER_(ID, USER_NAME, PASSWORD, ACCOUNT_EXPIRED, ACCOUNT_LOCKED, CREDENTIALS_EXPIRED, ENABLED)
VALUES (-1, 'admin', /*admin1234*/'$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha', FALSE, FALSE, FALSE, TRUE);

INSERT INTO USER_(ID, USER_NAME, PASSWORD, ACCOUNT_EXPIRED, ACCOUNT_LOCKED, CREDENTIALS_EXPIRED, ENABLED)
VALUES (-2, 'foodUser', /*reader1234*/'$2a$08$dwYz8O.qtUXboGosJFsS4u19LHKW7aCQ0LXXuNlRfjjGKwj5NfKSe', FALSE, FALSE, FALSE, TRUE);
INSERT INTO USERS_AUTHORITIES(USER_ID, AUTHORITY_ID) VALUES (-1, 1);
INSERT INTO USERS_AUTHORITIES(USER_ID, AUTHORITY_ID) VALUES (-1, 2);

INSERT INTO USERS_AUTHORITIES(USER_ID, AUTHORITY_ID) VALUES (-2, 2);
------------ USER ------------