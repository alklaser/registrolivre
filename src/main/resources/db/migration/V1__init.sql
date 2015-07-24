CREATE TABLE empresas (
    id bigint NOT NULL,
    cnpj character varying(255) NOT NULL,
    datacriacao timestamp without time zone,
    cep character varying(255),
    cidade character varying(255),
    complemento character varying(255),
    logradouro character varying(255),
    numero character varying(255),
    uf character varying(255),
    nomefantasia character varying(255) NOT NULL,
    razaosocial character varying(255),
    datacadastro timestamp without time zone
);

CREATE TABLE empresas_socios (
    empresas_id bigint NOT NULL,
    socios_id bigint NOT NULL
);

CREATE TABLE socios (
    id bigint NOT NULL,
    ativo boolean NOT NULL,
    cpf character varying(255),
    nome character varying(255)
);

CREATE TABLE documentos (
    id bigint NOT NULL,
    empresas_id bigint NOT NULL,
    url character varying(255),
    dataemissao timestamp without time zone,
    datacadastro timestamp without time zone
);

ALTER TABLE ONLY empresas ADD CONSTRAINT empresas_pkey PRIMARY KEY (id);

ALTER TABLE ONLY socios ADD CONSTRAINT socios_pkey PRIMARY KEY (id);

ALTER TABLE ONLY documentos ADD CONSTRAINT documentos_pkey PRIMARY KEY (id);

ALTER TABLE ONLY empresas_socios ADD CONSTRAINT fk_empresas_id FOREIGN KEY (empresas_id) REFERENCES empresas(id);

ALTER TABLE ONLY empresas_socios ADD CONSTRAINT fk_socios_id FOREIGN KEY (socios_id) REFERENCES socios(id);

ALTER TABLE ONLY documentos ADD CONSTRAINT fk_documentos_empresas_id FOREIGN KEY (empresas_id) REFERENCES empresas(id);