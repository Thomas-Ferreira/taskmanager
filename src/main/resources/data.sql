DROP TABLE IF EXISTS TASKS;

--CREATE TABLE USERS (
--    id INT AUTO_INCREMENT  PRIMARY KEY,
--    username VARCHAR(250) NOT NULL
--);

CREATE TABLE TASKS (
    id INT AUTO_INCREMENT  PRIMARY KEY, 
    titre VARCHAR(250) NOT NULL,
    contenu VARCHAR(250) NOT NULL,
    auteurId INT,
    FOREIGN KEY (auteurId) REFERENCES USERS(id)
);

INSERT INTO USERS (username) VALUES ('Thomas');
INSERT INTO TASKS (titre, contenu, auteurId) VALUES ('task 1', 'un contenu', (SELECT id FROM USERS WHERE username = 'Thomas'));