/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Esteban Rivarola, Daniela Romero, Agustín Rivarola
 */

public class DatabaseConnection {

    // Datos de conexión - Se configuran directamente en el código
  // Datos de conexión - Se configuran directamente en el código
    public static final String DB_NAME = "tfi_db";
    // URL base, solo conecta al servidor, sin especificar la BD
    private static final String BASE_URL = "jdbc:mariadb://localhost:3306"; 
    
    // URL completa, para el uso normal de la aplicación (CRUD)
    private static final String FULL_URL = BASE_URL + "/" + DB_NAME;
    private static final String USER = "root";
    private static final String PASSWORD = "";

    static {
        try {
            // 🔹 Carga del driver JDBC de MariaDB una sola vez
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // 🔹 Se lanza una excepción en caso de que el driver no esté disponible
            throw new RuntimeException("Error de conexión a la BBDD: No se encontró el driver JDBC.", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        // Validación adicional para asegurarse de que las credenciales no estén vacías
        if (FULL_URL == null || FULL_URL.isEmpty() || USER == null || USER.isEmpty() || PASSWORD == null ) {            throw new SQLException("Configuración de la base de datos incompleta o inválida.");
            }
            return DriverManager.getConnection(FULL_URL, USER, PASSWORD);
        }
    
    
    public static Connection getSystemConnection() throws SQLException {
        if (BASE_URL == null || BASE_URL.isEmpty() || USER == null || USER.isEmpty() || PASSWORD == null ) {
            throw new SQLException("Configuración de la base de datos incompleta o inválida.");
        }
        return DriverManager.getConnection(BASE_URL, USER, PASSWORD);
    }
}
