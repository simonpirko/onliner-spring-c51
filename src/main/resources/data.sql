INSERT INTO role(name) VALUE ('ADMIN');
INSERT INTO role(name) VALUE ('USER');
INSERT INTO role(name) VALUE ('MANAGER');


INSERT INTO users(email, firstName, lastName, password, username) VALUE ('admin@gmail.com', 'admin', 'admin', 'adMiN1', 'admin');
INSERT INTO users_roles(user_id, role_id) VALUE (1, 1);

INSERT INTO users(email, firstName, lastName, password, username) VALUE ('user@gmail.com', 'user', 'user', 'adMiN1', 'user');
INSERT INTO users_roles(user_id, role_id) VALUE (2, 2);