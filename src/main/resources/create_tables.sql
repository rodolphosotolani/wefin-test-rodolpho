CREATE TABLE usuario
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    nome     VARCHAR(255),
    email    VARCHAR(255),
    password VARCHAR(255),
    username VARCHAR(255),
    CONSTRAINT pk_usuario PRIMARY KEY (id),
    CONSTRAINT uc_usuario_username UNIQUE (username)
);

CREATE TABLE perfil
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    nome      VARCHAR(255),
    descricao VARCHAR(255),
    CONSTRAINT pk_perfil PRIMARY KEY (id)
);

ALTER TABLE perfil
    ADD CONSTRAINT uc_perfil_nome UNIQUE (nome);

CREATE TABLE usuario_perfis
(
    usuario_id BIGINT NOT NULL,
    perfis_id  BIGINT NOT NULL
);

ALTER TABLE usuario_perfis
    ADD CONSTRAINT fk_usuper_on_perfil FOREIGN KEY (perfis_id) REFERENCES perfil (id);

ALTER TABLE usuario_perfis
    ADD CONSTRAINT fk_usuper_on_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id);

CREATE TABLE pessoa
(
    id                 BIGINT NOT NULL,
    nome               VARCHAR(255),
    identificador      VARCHAR(255),
    tipo_identificador INTEGER,
    CONSTRAINT pk_pessoa PRIMARY KEY (id)
);

INSERT INTO public.usuario(email, nome, password, username)
VALUES ('admin@wefin.com.br', 'Administrador', '$2y$12$44KPHViErMC0s5oWLxtOCeV6jzbkBVLaX5rcGfsoS7V41cRnSdgTe', 'admin')
    ON CONFLICT (username) DO NOTHING;