-- init.sql

-- DDL: Creación de tablas. Usar IF NOT EXISTS para evitar errores de duplicidad.
CREATE TABLE IF NOT EXISTS pedidos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_pedido VARCHAR(10) NOT NULL UNIQUE,
    fecha DATE NOT NULL,
    cliente_nombre VARCHAR(100) NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    estado VARCHAR(20) NOT NULL, -- Ej: NUEVO, FACTURADO, ENVIADO
    eliminado BOOLEAN NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS envios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tracking VARCHAR(10) NOT NULL UNIQUE,
    empresa VARCHAR(50) NOT NULL,
    tipo VARCHAR(20) NOT NULL, -- Ej: ESTANDAR, EXPRESS
    costo DECIMAL(10, 2) NOT NULL,
    fechaDespacho DATE NOT NULL,
    fechaEstimada DATE,
    estado VARCHAR(20) NOT NULL, -- Ej: EN_PREPARACION, EN_TRANSITO, ENTREGADO
    id_pedido BIGINT NOT NULL UNIQUE, -- Clave foránea 1:1 con pedidos
    eliminado BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id)
);

