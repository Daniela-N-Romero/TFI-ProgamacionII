# GESTIÓN DE PEDIDOS Y ENVÍOS - Trabajo Final Integrador - Programación II

## DESCRIPCIÓN DEL PROYECTO

Este proyecto es un sistema de gestión de pedidos y envíos desarrollado en **Java (JDBC)** que implementa una arquitectura de **cinco capas** para garantizar la separación de responsabilidades, la encapsulación de la lógica de negocio y la gestión robusta de transacciones.

El sistema permite la administración completa del ciclo de vida de los pedidos y sus envíos asociados. Incluye:
* Patrón **Soft Delete** para la eliminación lógica de entidades.
* Sistema de **"Arranque Cero"** (`DBInitializer`) que crea la base de datos y carga datos iniciales automáticamente al ejecutarse por primera vez.

## ARQUITECTURA Y TECNOLOGÍAS

El proyecto sigue el principio de Separación de Responsabilidades con la siguiente estructura por capas:

### Capas del Sistema
1.  **Presentación (UI):** Punto de entrada (`Main`), lógica del menú interactivo.
2.  **Servicio (Lógica de Negocio):** Implementa reglas de negocio, validaciones y gestiona **transacciones complejas** que involucran múltiples DAOs.
3.  **DAO (Data Access Object):** Comunicación directa con la base de datos (CRUD y Soft Delete) utilizando JDBC.
4.  **Infraestructura (Config):** Gestión de conexión, transacciones y la inicialización automática (`DBInitializer`).
5.  **Base de Datos / Modelos:** Servidor MariaDB, Clases de Datos (`Pedido`, `Envio`) y Catálogos (`Enums`).

### Tecnologías
* **Lenguaje:** Java (JDK 21 LTS o superior).
* **Base de Datos:** MariaDB Server.
* **Conexión:** JDBC Nativo.
* **Arquitectura:** 5 Capas, Soft Delete.

## REQUISITOS E INSTALACIÓN 

### Requisitos Previos
* **Java Development Kit (JDK):** Versión 21 o superior.
* **MariaDB Server:** Una instancia local en ejecución (puerto 3306 por defecto).
* **IDE:** NetBeans, IntelliJ IDEA o Eclipse.

### Configuración del Driver JDBC (Importante)
El proyecto incluye el driver JDBC de MariaDB necesario en la estructura del código:

> **Inclusión del Driver:** El archivo `mariadb-java-client-X.X.X.jar` se encuentra en la carpeta **`/lib`** del proyecto. Esto asegura que no haya conflictos con rutas locales y que no necesites descargar el driver por separado. Verifica que tu IDE lo haya añadido correctamente a las librerías de compilación.

### Inicialización de la Base de Datos

El sistema maneja la creación de la base de datos de forma automática.

1.  Asegúrate de que el servidor MariaDB esté corriendo en `localhost:3306`.
2.  Verifica las credenciales en `src/Config/DatabaseConnection.java`:
3.  
    ```java
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Ajustar si tu root tiene contraseña
    ```
    
4.  La aplicación, al ejecutarse, creará la base de datos `tfi_db`, sus tablas y cargará los datos iniciales de ejemplo si es la primera vez.
5.  Crear las Tablas: Utiliza la siguiente estructura para las tablas pedidos y envios:

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

## EJECUCIÓN DEL PROYECTO 

1.  **Abrir:** Abre el proyecto en tu IDE (NetBeans/IntelliJ).
2.  **Ejecutar:** Haz clic derecho en la clase principal (`main.Main`) o usa la opción "Run" del proyecto.
3.  **Consola:** La aplicación iniciará, mostrará los logs de inicialización de la BBDD, y presentará el menú principal interactivo.

---

## ROLES Y CONTRIBUCIONES

* **Daniela (DevOps & Data Engineer):** Gestión de versiones (Git), infraestructura de conexión (`Config`), diseño de BBDD y depuración crítica.
* **Esteban (Backend & DAL Architect):** Arquitectura UML, implementación de la capa DAO, consultas SQL complejas y desarrollo de la interfaz de menús.
* **Agustín (Service Layer & Model Developer):** Lógica de negocio (Services), modelos y Enums, gestión transaccional (`TransactionManager`) y utilidades de generación de códigos.
  
## LINK A VIDEO 

https://www.youtube.com/watch?v=4yoGCChbBxg 
