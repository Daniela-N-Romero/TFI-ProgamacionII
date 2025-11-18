GESTIÓN DE PEDIDOS Y ENVÍOS - Trabajo Final Integrador - Programación II
DESCRIPCIÓN DEL PROYECTO

Este proyecto es un sistema de gestión de pedidos y envíos desarrollado en Java (JDBC) que implementa una arquitectura de cinco capas (Configuración, Modelos, DAO, Servicio y Main/UI) 
para garantizar la separación de responsabilidades, la encapsulación de la lógica de negocio y la gestión robusta de transacciones.
El sistema permite la administración completa del ciclo de vida de los pedidos, desde su creación hasta la gestión de su envío asociado. 
Utiliza el patrón Soft Delete para la eliminación lógica de entidades.

ARQUITECTURA Y TECNOLOGÍAS
El proyecto sigue el principio de Separación de Responsabilidades con una estructura por capas bien definida:

Capas
Models: Contiene las clases de datos (Pedido, Envio, Base) y los catálogos (Enums: Estado, Empresa, TipoEnvio).

Config: Gestiona la conexión a la base de datos (DatabaseConnection) y el manejo transaccional (TransactionManager).

DAO (Data Access Object): Responsable de la comunicación directa con la base de datos (CRUD y Soft Delete) utilizando JDBC.

Service: Implementa la lógica de negocio, validaciones y gestiona las transacciones complejas que abarcan múltiples DAOs.

Main / UI: Contiene el punto de entrada (Main), la lógica del menú interactivo (MenuHandler), y la inyección de dependencias (AppMenu).

Tecnologías
Lenguaje: Java (JDK 8 o superior)

Base de Datos: MariaDB

Conexión: JDBC

Arquitectura: 5 Capas, Soft Delete

REQUISITOS E INSTALACIÓN
Requisitos Previos
Asegúrate de tener instalado lo siguiente:

Java Development Kit (JDK) 8 o superior.

MariaDB o MySQL Server (o acceso a una instancia de base de datos).

IDE: NetBeans, IntelliJ IDEA o Eclipse.

Configuración de la Base de Datos
El proyecto está configurado para conectarse a una base de datos local llamada tfi_db.

Crear la Base de Datos:

SQL

CREATE DATABASE tfi_db;
USE tfi_db;
Crear las Tablas: Utiliza la siguiente estructura para las tablas pedidos y envios:

SQL

CREATE TABLE pedidos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    numero_pedido VARCHAR(10) UNIQUE NOT NULL,
    fecha DATE NOT NULL,
    cliente_nombre VARCHAR(100) NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    estado ENUM('NUEVO', 'FACTURADO', 'ENVIADO') NOT NULL,
    eliminado BOOLEAN DEFAULT 0
);

CREATE TABLE envios (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tracking VARCHAR(20) UNIQUE NOT NULL,
    empresa ENUM('ANDREANI', 'OCA', 'CORREO_ARG') NOT NULL,
    tipo ENUM('ESTANDAR', 'EXPRESS') NOT NULL,
    costo DECIMAL(10, 2) NOT NULL,
    fechaDespacho DATE,
    fechaEstimada DATE,
    estado ENUM('EN_PREPARACION', 'EN_TRANSITO', 'ENTREGADO') NOT NULL,
    id_pedido BIGINT UNIQUE,
    eliminado BOOLEAN DEFAULT 0,
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id)
);

Configurar Credenciales: Verifica y edita las constantes en el archivo Config/DatabaseConnection.java 
si tus credenciales de MariaDB son diferentes a las predeterminadas (root, sin contraseña):

Java

private static final String URL = "jdbc:mariadb://localhost:3306/tfi_db";

private static final String USER = "root"; 

private static final String PASSWORD = ""; 

Dependencias de Java

Asegúrate de que el conector JDBC de MariaDB esté incluido en las librerías de tu proyecto para establecer la comunicación con la base de datos.

EJECUCIÓN DEL PROYECTO
Abre el proyecto en tu IDE (NetBeans/IntelliJ).

Verifica que el conector JDBC esté añadido.

Ejecuta la clase main.Main.

La aplicación iniciará en la consola y mostrará el menú principal para comenzar la gestión.
