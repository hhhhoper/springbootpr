CREATE TABLE sys_role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role_code VARCHAR(50) NOT NULL UNIQUE,
    role_name VARCHAR(50) NOT NULL
);
INSERT INTO sys_role (role_code, role_name)
VALUES ('ADMIN', '管理员');
