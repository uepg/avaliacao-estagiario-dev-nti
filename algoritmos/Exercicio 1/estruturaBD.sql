-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: mysql:3306
-- Tempo de geração: 03/10/2019 às 01:32
-- Versão do servidor: 10.3.14-MariaDB-1:10.3.14+maria~bionic
-- Versão do PHP: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `comercial`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `Produto`
--

CREATE TABLE `Produto` (
  `id` int(10) UNSIGNED NOT NULL,
  `codigo` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `valorUnitario` float NOT NULL,
  `desc10` float DEFAULT NULL,
  `desc20` float DEFAULT NULL,
  `desc30` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Despejando dados para a tabela `Produto`
--


-- --------------------------------------------------------

--
-- Estrutura para tabela `Venda`
--

CREATE TABLE `Venda` (
  `id` int(10) UNSIGNED NOT NULL,
  `numVenda` int(11) NOT NULL,
  `vendido_em` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Despejando dados para a tabela `Venda`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `Venda_produto`
--

CREATE TABLE `Venda_produto` (
  `id` int(10) UNSIGNED NOT NULL,
  `Produto_id` int(10) UNSIGNED NOT NULL,
  `Venda_id` int(10) UNSIGNED NOT NULL,
  `quantidade` int(11) NOT NULL,
  `valorTotal` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `Produto`
--
ALTER TABLE `Produto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo_UNIQUE` (`codigo`);

--
-- Índices de tabela `Venda`
--
ALTER TABLE `Venda`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `Venda_produto`
--
ALTER TABLE `Venda_produto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Venda_produto_Produto_idx` (`Produto_id`),
  ADD KEY `fk_Venda_produto_Venda1_idx` (`Venda_id`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `Produto`
--
ALTER TABLE `Produto`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `Venda`
--
ALTER TABLE `Venda`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `Venda_produto`
--
ALTER TABLE `Venda_produto`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `Venda_produto`
--
ALTER TABLE `Venda_produto`
  ADD CONSTRAINT `fk_Venda_produto_Produto` FOREIGN KEY (`Produto_id`) REFERENCES `Produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Venda_produto_Venda1` FOREIGN KEY (`Venda_id`) REFERENCES `Venda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
