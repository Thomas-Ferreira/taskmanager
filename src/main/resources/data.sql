DROP TABLE IF EXISTS TASKS;

CREATE TABLE TASKS (
    id INT AUTO_INCREMENT  PRIMARY KEY, 
    titre VARCHAR(250) NOT NULL,
    contenu VARCHAR(250) NOT NULL,
    auteur VARCHAR(250) NOT NULL
);

INSERT INTO TASKS (titre, contenu, auteur) VALUES ('task 1', 'un contenu', 'Thomas');