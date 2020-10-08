/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.controlador;

import aerolínea.modelo.Aerolinea;
import aerolínea.modelo.ModeloAero;
import aerolínea.modelo.Vuelo;
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
    public void accionAero(Aerolinea aero){
       
            modelo.agregar(aero);
        
    }
    public void accionVue(Vuelo vue){
       
            modelo.agregar(vue);
        
    }
    public void cambio(String nombre1, Aerolinea aero){
        modelo.modifi(nombre1,aero);
    }
    public void eliminarVue(String num){
        modelo.eliminarVue(num);
    }
}
