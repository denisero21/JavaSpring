CREATE TABLE user_
(
    id              BIGSERIAL PRIMARY KEY,
    name            VARCHAR(200),
    mail           VARCHAR(255)            NOT NULL,
    password        VARCHAR(60)            NOT NULL
);

CREATE UNIQUE INDEX users_unique_email_idx ON user_ (mail);

CREATE TABLE role_
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(120),
    creation_date TIMESTAMP DEFAULT now() NOT NULL
);

CREATE UNIQUE INDEX users_role_idx ON role_ (name);

CREATE TABLE privilege_
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(120)
);

CREATE TABLE user_role
(
    user_id BIGSERIAL NOT NULL,
    role_id BIGSERIAL NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_ (id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES role_ (id) ON DELETE CASCADE
);

CREATE TABLE role_privilege
(
    role_id      BIGSERIAL NOT NULL,
    privilege_id BIGSERIAL NOT NULL,
    FOREIGN KEY (role_id) REFERENCES role_ (id) ON DELETE CASCADE,
    FOREIGN KEY (privilege_id) REFERENCES privilege_ (id)
);

CREATE TABLE IF NOT EXISTS restaurant (
    id BIGSERIAL PRIMARY KEY,
    name varchar(255) NOT NULL,
    phone varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    info varchar(255) NOT NULL
);

drop table dish;

CREATE TABLE IF NOT EXISTS dish (
  id BIGSERIAL PRIMARY KEY,
  restaurant_id BIGSERIAL NOT NULL,
  menu_category_id BIGSERIAL,
  name varchar(255) NOT NULL,
  cost decimal NOT NULL,
  FOREIGN KEY (restaurant_id) REFERENCES restaurant (id),
    FOREIGN KEY (menu_category_id) REFERENCES menu_category (id)
);

CREATE TABLE IF NOT EXISTS menu_category (
    id BIGSERIAL PRIMARY KEY,
    name varchar(255) NOT NULL
);