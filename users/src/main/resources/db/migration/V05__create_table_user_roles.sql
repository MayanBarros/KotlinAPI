CREATE TABLE user_roles(
    user_id BIGINT NOT NULL,
    role VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES `kotlin_api`.`tb_user` (`id_user`)
);