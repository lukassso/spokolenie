INSERT INTO users (email_adress, first_name, last_name, password) VALUES ('admin@example.com', 'Jan', 'Nowak', '$2a$10$.8Zw9Wak.VV/XNjQoB5kAeZFGx7Ujd2lEUM6iUiaImQILpuBqkOOu');

INSERT INTO authority(name, id) VALUES ('ROLE_ADMIN', 0);
INSERT INTO authority(name, id) VALUES ('ROLE_USER', 1);
INSERT INTO user_authority(authority_id, user_id) VALUES (0, 1);
