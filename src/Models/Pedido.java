/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.time.LocalDate;

/**
 *
 * @author Daniela Nahir Romero
 */
public class Pedido extends Base{
    //Definimos los atributos:
    private String numero;
    private java.time.LocalDate fecha;
    private String clienteNombre;
    private String total;

    //Constructor completo:
    public Pedido(String numero, LocalDate fecha, String clienteNombre, String total, int id) {
        super(id, false); // Llama al constructor de Base con eliminado=false
        this.numero = numero;
        this.fecha = fecha;
        this.clienteNombre = clienteNombre;
        this.total = total;
    }
    
    //Constructor por defecto:
    public Pedido() {
        super();
    }
    
    //Getters y Setters

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    //Generamos el toString:
    @Override
    public String toString() {
        return "Pedido{" + "numero=" + numero + ", fecha=" + fecha + ", clienteNombre=" + clienteNombre + ", total=" + total + '}';
    }
    
    
    
    
    
    
    
}
