CREATE TABLE `tb_user_address` (
	`user_id_user` BIGINT(19) NOT NULL,
	`address_id_address` BIGINT(19) NOT NULL,
	UNIQUE INDEX `UK_gapnu0grlk55s5huc0u3rllei` (`address_id_address`) USING BTREE,
	INDEX `FKn70vncd23dcrg526sdgxxpc3a` (`user_id_user`) USING BTREE,
	CONSTRAINT `FKjtu10ameq9gmab6t2k5icq5j4` FOREIGN KEY (`address_id_address`) REFERENCES `kotlin_api`.`tb_address` (`id_address`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FKn70vncd23dcrg526sdgxxpc3a` FOREIGN KEY (`user_id_user`) REFERENCES `kotlin_api`.`tb_user` (`id_user`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;