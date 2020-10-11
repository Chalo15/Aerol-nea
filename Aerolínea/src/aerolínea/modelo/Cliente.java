/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.modelo;

/**
 *
 * @author Gonzalo
 */
public class Cliente {

    public Cliente(String cedula, String nombre, String apellido1, String apellido2, int cantidad, String numvue) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.cantidad = cantidad;
        this.numerovulo=numvue;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Informacion del cliente: " + "Cédula= " + cedula + ", Nombre= " + nombre + ", Primer Apellido= " + apellido1 + ", Segundo Apellido= " + apellido2 + ", Número de vuelo= " + numerovulo +"Cantidad de asientos= "+ cantidad;
    }
    
    
   private String cedula,nombre,apellido1,apellido2,numerovulo;
   private int cantidad;
}
