DROP DATABASE IF EXISTS user_db;
CREATE DATABASE user_db;
USE user_db;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS role;

CREATE TABLE user
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    username VARCHAR(255)          NOT NULL UNIQUE,
    password VARCHAR(255)          NOT NULL,
    email    VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE `role`
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    name        VARCHAR(255)          NOT NULL UNIQUE,
    descrizione VARCHAR(255)          NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE user_role
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    CONSTRAINT pk_user_role PRIMARY KEY (user_id, role_id),
    CONSTRAINT FK_USER_ROLE_ON_ROLE FOREIGN KEY (role_id) REFERENCES `role` (id),
    CONSTRAINT FK_USER_ROLE_ON_USER FOREIGN KEY (user_id) REFERENCES user (id)
);
-- Inserimento dati di esempio

-- Inserimento dati utente
INSERT INTO user (username, password, email)
VALUES ('Francesco_Vampa', 'password123', 'fv@gmail.com'),
       ('Federico_Falcone', 'securepass', 'ff@gmail.com');
-- Inserimento dati ruolo
INSERT INTO `role` (id, name, descrizione)
VALUES (1, 'USER', 'Standard user with limited access'),
       (2, 'ADMIN', 'Administrator with full access');
-- Assegnazione ruoli agli utenti
INSERT INTO user_role (user_id, role_id)
VALUES (1, 1), -- Assegna il ruolo USER a Francesco Vampa
       (2, 1), -- Assegna il ruolo USER a Federico Falcone
       (2, 2); -- Assegna il ruolo ADMIN a Federico Falcone

