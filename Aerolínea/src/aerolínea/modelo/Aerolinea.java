/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.modelo;

import java.util.Date;

/**
 *
 * @author Gonzalo
 */
public class Aerolinea {
    
    public Aerolinea(String nom, Date fech){
        this.nombre=nom;
        this.fecha=fech;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    private String nombre;
    private Date fecha;
}
