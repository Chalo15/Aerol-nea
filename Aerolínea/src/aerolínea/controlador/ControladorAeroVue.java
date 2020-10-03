/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.controlador;

import aerolínea.modelo.ModeloAero;
import java.util.Date;
import java.util.Observer;

/**
 *
 * @author Gonzalo
 */
public class ControladorAeroVue {
    private ModeloAero modelo;
    
    public ControladorAeroVue(){
        modelo=new ModeloAero();
    }
    public void agregarObservador(Observer vis){
        modelo.addObserver(vis);
    }
    public void accion(String nom,Date fecha){
       
            modelo.agregar(nom,fecha);
        
    }
    public void cambio(String nombre1, String nombre2,Date fecha){
        modelo.modifi(nombre1,nombre2,fecha);
    }
}
