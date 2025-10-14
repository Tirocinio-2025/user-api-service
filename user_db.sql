DROP DATABASE IF EXISTS user_db;
CREATE DATABASE user_db;
USE user_db;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS user_role;

CREATE TABLE user
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    username VARCHAR(50)           NOT NULL,
    password VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id),
    CONSTRAINT uc_user_username UNIQUE (username)
);

CREATE TABLE `role`
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(50)           NOT NULL,
    CONSTRAINT pk_role PRIMARY KEY (id),
    CONSTRAINT uc_role_name UNIQUE (name)
);

CREATE TABLE user_role
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    user_id BIGINT                NOT NULL,
    role_id BIGINT                NOT NULL,
    CONSTRAINT pk_user_role PRIMARY KEY (id),
    CONSTRAINT uc_5d1f693e886f85fa06e1ed745 UNIQUE (user_id, role_id),
    CONSTRAINT FK_USER_ROLE_ON_ROLE FOREIGN KEY (role_id) REFERENCES `role` (id),
    CONSTRAINT FK_USER_ROLE_ON_USER FOREIGN KEY (user_id) REFERENCES user (id)
);
-- Inserimento dati di esempio

-- Inserimento dati utente
INSERT INTO user (username, password)
VALUES ('Francesco_Vampa', 'password123'),
       ('Federico_Falcone', 'securepass');
-- Inserimento dati ruolo
INSERT INTO `role` (id, name)
VALUES (1, 'USER'),
       (2, 'ADMIN');
-- Assegnazione ruoli agli utenti
INSERT INTO user_role (user_id, role_id)
VALUES (1, 1), -- Assegna il ruolo USER a Francesco Vampa
       (2, 1), -- Assegna il ruolo USER a Federico Falcone
       (2, 2); -- Assegna il ruolo ADMIN a Federico Falcone

