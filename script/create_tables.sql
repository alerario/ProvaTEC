CREATE TABLE public.categoria
(
    idcategoria integer NOT NULL,
    descricao character varying(60) COLLATE pg_catalog."default",
    CONSTRAINT categoria_pkey PRIMARY KEY (idcategoria)
);
CREATE TABLE public.fornecedor
(
    idfornecedor integer NOT NULL,
    nome character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT fornecedor_pkey PRIMARY KEY (idfornecedor)
);
CREATE TABLE public.produto
(
    idproduto integer NOT NULL,
    descricao character varying(50) COLLATE pg_catalog."default",
    categoria integer,
    CONSTRAINT produto_pkey PRIMARY KEY (idproduto),
    CONSTRAINT "fg_Cat" FOREIGN KEY (categoria)
        REFERENCES public.categoria (idcategoria) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
CREATE TABLE public.prodforn
(
    produto integer NOT NULL,
    fornecedor integer NOT NULL,
    CONSTRAINT prodforn_pkey PRIMARY KEY (produto, fornecedor),
    CONSTRAINT fgforn FOREIGN KEY (fornecedor)
        REFERENCES public.fornecedor (idfornecedor) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fgprod FOREIGN KEY (produto)
        REFERENCES public.produto (idproduto) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
