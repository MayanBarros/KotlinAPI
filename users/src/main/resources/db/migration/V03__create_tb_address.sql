CREATE TABLE tb_address (
  id_address BIGINT AUTO_INCREMENT NOT NULL,
   address VARCHAR(255) NOT NULL,
   number VARCHAR(50) NOT NULL,
   city VARCHAR(50) NOT NULL,
   state VARCHAR(50) NOT NULL,
   CONSTRAINT pk_tb_address PRIMARY KEY (id_address)
);