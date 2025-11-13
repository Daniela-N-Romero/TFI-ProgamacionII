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
public class Envio extends Base{
    //Definimos los atributos:
    private String tracking;
    private double costo;
    private java.time.LocalDate fechaDespacho;
    private java.time.LocalDate fechaEstimada;
    
    //Constructor completo:
    public Envio(String tracking, double costo, LocalDate fechaDespacho, LocalDate fechaEstimada, int id) {
        super(id, false); //Llama al constructor de Base con eliminado=false
        this.tracking = tracking;
        this.costo = costo;
        this.fechaDespacho = fechaDespacho;
        this.fechaEstimada = fechaEstimada;
    }
    
    //Constructor por defecto:
    public Envio() {
        super();
    }
    
    //Getters y Setters

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public LocalDate getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(LocalDate fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public LocalDate getFechaEstimada() {
        return fechaEstimada;
    }

    public void setFechaEstimada(LocalDate fechaEstimada) {
        this.fechaEstimada = fechaEstimada;
    }
    
    
           
    
}
