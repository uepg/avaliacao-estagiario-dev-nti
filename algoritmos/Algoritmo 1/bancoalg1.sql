-- Database: vendas

-- DROP DATABASE IF EXISTS vendas;

CREATE DATABASE vendas
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;


-- Table: public.cliente

-- DROP TABLE IF EXISTS public.cliente;

CREATE TABLE IF NOT EXISTS public.cliente
(
    idcliente integer NOT NULL DEFAULT nextval('"cliente_idCliente_seq"'::regclass),
    nomecliente character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "pk_Cliente" PRIMARY KEY (idcliente)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.cliente
    OWNER to postgres;

-- Table: public.produto

-- DROP TABLE IF EXISTS public.produto;

CREATE TABLE IF NOT EXISTS public.produto
(
    idproduto integer NOT NULL DEFAULT nextval('"produto_idProduto_seq"'::regclass),
    valorproduto numeric NOT NULL,
    qtdeproduto integer NOT NULL DEFAULT 0,
    nomeproduto character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "pk_Produto" PRIMARY KEY (idproduto)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.produto
    OWNER to postgres;

-- Table: public.venda

-- DROP TABLE IF EXISTS public.venda;

CREATE TABLE IF NOT EXISTS public.venda
(
    idvenda integer NOT NULL DEFAULT nextval('venda_idvenda_seq'::regclass),
    datavenda character varying COLLATE pg_catalog."default" NOT NULL,
    qtdevenda integer NOT NULL,
    desconto numeric NOT NULL,
    totalvenda numeric NOT NULL,
    idcliente integer NOT NULL,
    idproduto integer NOT NULL,
    CONSTRAINT "pk_Venda" PRIMARY KEY (idvenda),
    CONSTRAINT "fk_Cliente" FOREIGN KEY (idcliente)
        REFERENCES public.cliente (idcliente) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "fk_Produto" FOREIGN KEY (idproduto)
        REFERENCES public.produto (idproduto) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.venda
    OWNER to postgres;