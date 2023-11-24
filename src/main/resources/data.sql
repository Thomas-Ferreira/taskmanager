DROP TABLE IF EXISTS tasks

CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(250) NOT NULL,
    contenu VARCHAR(250) NOT NULL,
    auteur VARCHAR(250) NOT NULL
);

INSERT INTO tasks (titre, contenu, auteur) VALUES
    ('task 1', 'un contenu', 'Thomas')