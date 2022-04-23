INSERT INTO role(name) VALUE ('ADMIN');
INSERT INTO role(name) VALUE ('USER');
INSERT INTO role(name) VALUE ('MANAGER');

# USERS
INSERT INTO users(email, firstName, lastName, password, username) VALUE ('admin@gmail.com', 'admin', 'admin', 'adMiN1', 'admin');
INSERT INTO users_roles(user_id, role_id) VALUE (1, 1);

INSERT INTO users(email, firstName, lastName, password, username) VALUE ('user@gmail.com', 'user', 'user', 'adMiN1', 'user');
INSERT INTO users_roles(user_id, role_id) VALUE (2, 2);


INSERT INTO users(email, firstName, lastName, password, username) VALUE ('manager@gmail.com', 'manager', 'manager', 'adMiN1', 'manager');
INSERT INTO users_roles(user_id, role_id) VALUE (3, 3);

INSERT INTO users(email, firstName, lastName, password, username) VALUE ('manager1@gmail.com', 'manager1', 'manager1', 'adMiN1', 'manager1');
INSERT INTO users_roles(user_id, role_id) VALUE (4, 3);

INSERT INTO users(email, firstName, lastName, password, username) VALUE ('manager2@gmail.com', 'manager2', 'manager2', 'adMiN1', 'manager2');
INSERT INTO users_roles(user_id, role_id) VALUE (5, 3);


# PRODUCT CATEGORY
INSERT INTO product_category(name) VALUES ('ELECTRONICS');
INSERT INTO product_category(name) VALUES ('COMPUTERS AND NETWORKS');

# PRODUCT SUBCATEGORY
INSERT INTO product_subcategory(name, product_category_id) VALUE ('PHONES', 1);
INSERT INTO product_subcategory(name, product_category_id) VALUE ('LAPTOPS, COMPUTERS, MONITORS', 2);

# PRODUCT TYPE
INSERT INTO product_type(name, product_subcategory_id) VALUE ('SMARTPHONE', 1);
INSERT INTO product_type(name, product_subcategory_id) VALUE ('RADIOPHONE', 1);
INSERT INTO product_type(name, product_subcategory_id) VALUE ('LAPTOP', 2);
INSERT INTO product_type(name, product_subcategory_id) VALUE ('MONOBLOCK', 2);

# PRODUCT PROPERTY GROUP
INSERT INTO product_property_group(name) VALUE ('General information');
INSERT INTO product_property_group(name) VALUE ('Main characteristics');

# PRODUCT PROPERTY
INSERT INTO product_property(name) VALUE ('Market launch date');
INSERT INTO product_property(name) VALUE ('Operation system');
INSERT INTO product_property(name) VALUE ('Display size');
INSERT INTO product_property(name) VALUE ('Display resolution');
INSERT INTO product_property(name) VALUE ('Base type');
INSERT INTO product_property(name) VALUE ('AOH');

# PAIR PROPERTY VALUE
INSERT INTO pair_property_value(value, product_property_id, product_property_group_id) VALUES ('2016', 1, 1),('2020', 1, 1);
INSERT INTO pair_property_value(value, product_property_id, product_property_group_id) VALUES ('Android', 2, 2),('Apple iOS', 2, 2);
INSERT INTO pair_property_value(value, product_property_id, product_property_group_id) VALUES ('6', 3, 2),('6.5', 3, 2),('6.7', 3, 2);
INSERT INTO pair_property_value(value, product_property_id, product_property_group_id) VALUES ('720x1280', 4, 2),('1080x1920', 4, 2),('1440x2560', 4, 2);
INSERT INTO pair_property_value(value, product_property_id, product_property_group_id) VALUES ('telephone line/modem', 5, 2);
INSERT INTO pair_property_value(value, product_property_id, product_property_group_id) VALUES ('true', 6, 2), ('false', 6, 2);

# MANUFACTURER
INSERT INTO manufacturer(name) VALUES ('Huawei '),('Xiaomi'),('Panasonic'),('TeXet');

# PRODUCT
INSERT INTO product(name, manufacturer_id, product_type_id) VALUE ('Smartphone Huawei nova 9 SE JLN-LX1 8GB/128GB (crystal blue)', 1, 1);
INSERT INTO product(name, manufacturer_id, product_type_id) VALUE ('Smartphone Xiaomi Redmi Note 10 Pro 8GB/128GB (gray onyx)', 2, 1);
INSERT INTO product(name, manufacturer_id, product_type_id) VALUE ('Radiophone Panasonic KX-TG2511RUT', 3, 2);
INSERT INTO product(name, manufacturer_id, product_type_id) VALUE ('Radiophone TeXet TX-D6705A', 4, 2);



# PRODUCTS PROPERTIES
INSERT INTO products_pairs_attribute_value(product_id, pair_attribute_value_id) VALUES (1, 1),(1, 3),(1, 5),(1, 8);
INSERT INTO products_pairs_attribute_value(product_id, pair_attribute_value_id) VALUES (2, 2),(2, 3),(2, 6),(2, 10);
INSERT INTO products_pairs_attribute_value(product_id, pair_attribute_value_id) VALUES (3, 1),(3, 11),(3, 12);
INSERT INTO products_pairs_attribute_value(product_id, pair_attribute_value_id) VALUES (4, 2),(4, 11),(4, 13);


# STATE REGISTRATION INFORMATION
INSERT INTO state_registration_information(entryTradeRegisterDate, legalEntityName, payerAccountNumber, registrationAuthority, stateRegistrationDate, stateRegistrationLegalEntityPlace) VALUE ('2001-01-01', 'OOO TTTT', 123456789, 'Minsk gov', '2001-02-02', 'Minsk');
INSERT INTO state_registration_information(entryTradeRegisterDate, legalEntityName, payerAccountNumber, registrationAuthority, stateRegistrationDate, stateRegistrationLegalEntityPlace) VALUE ('2002-02-02', 'OOO HHHH', 987654321, 'Minsk gov', '2002-03-03', 'Minsk');

# SELLER
INSERT INTO seller(verifiedSeller, stateRegistrationInformation_id) VALUE (true, 1);
INSERT INTO seller(verifiedSeller, stateRegistrationInformation_id) VALUE (true, 2);

# SELLER MANAGERS
INSERT INTO seller_users(seller_id, managers_id) VALUES (1, 3),(1, 4);
INSERT INTO seller_users(seller_id, managers_id) VALUES (2, 5);
