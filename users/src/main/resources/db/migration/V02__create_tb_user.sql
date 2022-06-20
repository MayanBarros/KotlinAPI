CREATE TABLE tb_user (
  id_user BIGINT AUTO_INCREMENT NOT NULL,
   name VARCHAR(100) NOT NULL,
   age INT NOT NULL,
   phone_number VARCHAR(20) NOT NULL,
   email VARCHAR(150) NOT NULL,
   password VARCHAR(255) NOT NULL,
   is_active BIT(1) NOT NULL,
   CONSTRAINT pk_tb_user PRIMARY KEY (id_user)
);