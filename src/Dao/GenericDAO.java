/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import java.util.List;
import java.sql.*;

/**
 *
 * @author Daniela Nahir Romero
 */
public interface GenericDAO<T> {
    
    void insertar(T entidad) throws Exception;
    
    void actualizar(T entidad) throws Exception;
    
    void eliminar(long id) throws Exception;
    
    T getById(long id) throws Exception;
    
    List<T> getAll() throws Exception;
    
        // --- MÉTODOS CRUD TRANSACCIONALES (Requieren Connection externa) ---
    // Usados por la capa Service para agrupar múltiples operaciones
    void insertarTx(T entidad, Connection conn) throws Exception;

    void actualizarTx(T entidad, Connection conn) throws Exception;

    void eliminarTx(long id, Connection conn) throws Exception;

    T getByIdTx(long id, Connection conn) throws Exception;
    
}
