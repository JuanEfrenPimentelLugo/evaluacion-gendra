CREATE SCHEMA gendra;

CREATE TABLE gendra.t_productos (
	id_t_productos bigserial NOT NULL,
	nombre varchar(50) NULL,
	precio decimal NULL,
	CONSTRAINT pk_t_productos PRIMARY KEY (id_t_productos)
);

CREATE SEQUENCE gendra.t_productos_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
	

CREATE TABLE gendra.t_clientes (
	id_t_clientes bigserial NOT NULL,
	nombre varchar(50) NULL,
	apellido_p varchar(50) NULL,
	apellido_m varchar(50) NULL,
	correo varchar(50) NULL,
	telefono varchar(20) NULL,
	CONSTRAINT pk_t_clientes PRIMARY KEY (id_t_clientes)
);

CREATE SEQUENCE gendra.t_clientes_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


CREATE TABLE gendra.t_ordenes (
	id_t_ordenes bigserial NOT NULL,
	id_t_clientes bigserial NOT null,
	fecha date NULL,
	CONSTRAINT pk_t_ordenes PRIMARY KEY (id_t_ordenes),
	CONSTRAINT fk_t_ordenes_t_clientes FOREIGN KEY (id_t_clientes) REFERENCES gendra.t_clientes(id_t_clientes)
);

CREATE SEQUENCE gendra.t_ordenes_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


CREATE TABLE gendra.t_orden_productos (
	id_t_orden_productos bigserial NOT NULL,
	id_t_ordenes bigserial NOT NULL,
	id_t_productos bigserial NOT NULL,
	cantidad int4 NOT NULL,
	CONSTRAINT pk_t_orden_productos PRIMARY KEY (id_t_orden_productos),
	CONSTRAINT fk_t_orden_productos_t_ordenes FOREIGN KEY (id_t_ordenes) REFERENCES gendra.t_ordenes(id_t_ordenes),
	CONSTRAINT fk_t_orden_productos_t_productos FOREIGN KEY (id_t_productos) REFERENCES gendra.t_productos(id_t_productos)
);

CREATE SEQUENCE gendra.t_orden_productos_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
	
