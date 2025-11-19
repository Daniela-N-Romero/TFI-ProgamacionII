-- init.sql

-- DDL: Creación de tablas. Usar IF NOT EXISTS para evitar errores de duplicidad.
CREATE TABLE IF NOT EXISTS pedidos (
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    eliminado TINYINT(1) NOT NULL DEFAULT 0,
    numero_pedido VARCHAR(20) NOT NULL UNIQUE,
    fecha datetime NOT NULL,
    cliente_nombre VARCHAR(120) NOT NULL,
    total DECIMAL(12,2) NOT NULL,
    estado ENUM('NUEVO', 'FACTURADO', 'ENVIADO')
);

CREATE TABLE IF NOT EXISTS envios (
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    eliminado TINYINT(1) NOT NULL DEFAULT 0,
    tracking VARCHAR(40) UNIQUE,
    empresa ENUM('ANDREANI', 'OCA', 'CORREO_ARG'),
    tipo ENUM('ESTANDAR', 'EXPRESS'),
    costo DECIMAL(10,2),
    fechaDespacho DATE,
    fechaEstimada DATE,
    estado ENUM('EN_PREPARACION', 'EN_TRANSITO', 'ENTREGADO'),
    `id_pedido` BIGINT NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id)
);

