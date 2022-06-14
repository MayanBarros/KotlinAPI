CREATE TABLE tb_address (
  id_address BIGINT AUTO_INCREMENT NOT NULL,
   address VARCHAR(255) NOT NULL,
   number VARCHAR(255) NOT NULL,
   zip_postal VARCHAR(255) NOT NULL,
   country VARCHAR(255) NOT NULL,
   state VARCHAR(255) NOT NULL,
   city VARCHAR(255) NOT NULL,
   CONSTRAINT pk_tb_address PRIMARY KEY (id_address)
);