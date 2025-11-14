/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Daniela Nahir Romero
 */
public abstract class Base {
    //Definimos atributos que serán comunes a todas las clases:
    private int id;
    private boolean eliminado;

    
    //Constructor completo con todos los campos:
    protected Base(int id, boolean eliminado) {
        this.id = id;
        this.eliminado = eliminado; 
    }
    
    //Constructor por defecto:
    protected Base() {
        this.eliminado = false;
        }
    
    
//Getter y Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //Método que Verifica si la entidad está marcada como eliminada.
    //@return true si está eliminada, false si está activa:
    public boolean isEliminado() {
        return eliminado;     
    }
    //Setter que marca o desmarca la entirad como eliminada
    //true para para marcar como eliminada, false para reactivar:
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    
    
}
