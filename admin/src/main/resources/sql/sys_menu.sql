CREATE TABLE sys_menu (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    parent_id BIGINT DEFAULT 0,
    menu_name VARCHAR(50),
    path VARCHAR(100),
    component VARCHAR(100),
    type TINYINT COMMENT '0目录 1菜单 2按钮',
    permission VARCHAR(100)
);
INSERT INTO sys_menu (menu_name, path, type, permission)
VALUES ('用户管理', '/user', 1, 'sys:user:list');
