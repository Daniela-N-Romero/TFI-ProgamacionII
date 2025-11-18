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

-- DML: Inserción de datos iniciales (Seed Data). Usar INSERT IGNORE para idempotencia.
-- Pedido 1
INSERT INTO pedidos (numero_pedido, fecha, cliente_nombre, total, estado) VALUES
('P0001', '2025-11-01 10:30:00', 'Juan Pérez', 15000.50, 'FACTURADO'),
('P0002', '2025-11-02 14:45:00', 'María López', 5200.00, 'ENVIADO'),
('P0003', '2025-11-03 09:00:00', 'Carlos García', 850.75, 'NUEVO'),
('P0004', '2025-11-04 18:20:00', 'Laura Torres', 22500.99, 'FACTURADO'),
('P0005', '2025-11-05 11:15:00', 'Roberto Sánchez', 3100.00, 'ENVIADO');

-- Envío para Pedido ID 1
INSERT INTO envios (tracking, empresa, tipo, costo, fechaDespacho, fechaEstimada, estado, id_pedido) VALUES
('TRK0001A', 'ANDREANI', 'ESTANDAR', 950.00, '2025-11-02', '2025-11-08', 'EN_TRANSITO', 1),
('TRK0002O', 'OCA', 'EXPRESS', 1500.00, '2025-11-03', '2025-11-05', 'ENTREGADO', 2),
('TRK0003C', 'CORREO_ARG', 'ESTANDAR', 720.50, '2025-11-05', '2025-11-12', 'EN_TRANSITO', 4),
('TRK0004O', 'OCA', 'ESTANDAR', 800.00, '2025-11-06', '2025-11-13', 'EN_PREPARACION', 3);


