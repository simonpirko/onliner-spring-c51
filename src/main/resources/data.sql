INSERT INTO role(name) VALUE ('ADMIN');
INSERT INTO role(name) VALUE ('USER');
INSERT INTO role(name) VALUE ('MANAGER');


INSERT INTO users(email, firstName, lastName, password, username) VALUE ('admin@gmail.com', 'admin', 'admin', 'adMiN1', 'admin');
INSERT INTO users_roles(user_id, role_id) VALUE (1, 1);

INSERT INTO users(email, firstName, lastName, password, username) VALUE ('user@gmail.com', 'user', 'user', 'adMiN1', 'user');
INSERT INTO users_roles(user_id, role_id) VALUE (2, 2);


INSERT INTO smartphone(name, displayResolution, os, platform, ram, storage, price) VALUE ('Samsung Galaxy Z Flip3 5G 8GB/256GB (red)', 1, 2, 3, 4, 5, 12);
INSERT INTO smartphone(name, displayResolution, os, platform, ram, storage, price) VALUE ('Samsung Galaxy Z Flip3 8G 16GB/500GB (green)', 1, 2, 3, 4, 5, 12);

INSERT INTO state_registration_information(legalEntityName, stateRegistrationLegalEntityPlace, payerAccountNumber, seller) VALUE ('seller', 1, 666, 1);

INSERT INTO seller(stateRegistrationInformation, verifiedSeller) VALUE (1, true);

INSERT INTO sellerfeedback(title, description, grade, user, seller) VALUE ('test', 'test', 'test', 1, 1);
