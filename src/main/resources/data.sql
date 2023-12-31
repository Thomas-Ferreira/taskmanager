DROP TABLE IF EXISTS TASKS;

--CREATE TABLE USERS (
--    id INT AUTO_INCREMENT  PRIMARY KEY,
--    username VARCHAR(250) NOT NULL
--);

CREATE TABLE TASKS (
    id INT AUTO_INCREMENT  PRIMARY KEY, 
    titre VARCHAR(250) NOT NULL,
    contenu VARCHAR(250) NOT NULL,
    USER_ID INT,
    FOREIGN KEY (USER_ID) REFERENCES USERS(id)
);

INSERT INTO USERS (username) VALUES ('Thomas');
INSERT INTO TASKS (titre, contenu, USER_ID) VALUES ('task 1', 'un contenu', (SELECT id FROM USERS WHERE username = 'Thomas'));
INSERT INTO TASKS (titre, contenu, USER_ID) VALUES ('task 2', 'un autre contenu', (SELECT id FROM USERS WHERE username = 'Thomas'));