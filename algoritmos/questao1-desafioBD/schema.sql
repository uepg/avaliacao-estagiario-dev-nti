CREATE TABLE `Venda` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`data` DATE NOT NULL,
	`hora` DATETIME NOT NULL,
	`valorTotal` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Produto` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nome` varchar(255) NOT NULL,
	`valorUnidade` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `VendaProduto` (
	`vendaId` INT NOT NULL,
	`produtoId` INT NOT NULL,
	`quantidade` INT NOT NULL,
	`valorTotalAposDesconto` INT NOT NULL
);

ALTER TABLE `VendaProduto` ADD CONSTRAINT `VendaProduto_fk0` FOREIGN KEY (`vendaId`) REFERENCES `Venda`(`id`);

ALTER TABLE `VendaProduto` ADD CONSTRAINT `VendaProduto_fk1` FOREIGN KEY (`produtoId`) REFERENCES `Produto`(`id`);




