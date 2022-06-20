CREATE TABLE tb_address (
  id_address BIGINT AUTO_INCREMENT NOT NULL,
   zip_code VARCHAR(20) NOT NULL,
   address VARCHAR(255) NOT NULL,
   number VARCHAR(100) NOT NULL,
   city VARCHAR(100) NOT NULL,
   state VARCHAR(100) NOT NULL,
   CONSTRAINT pk_tb_address PRIMARY KEY (id_address)
);