/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.controlador;

import aerolínea.modelo.ModeloUsuarios;
import java.util.HashMap;
import java.util.Observer;

/**
 *
 * @author USER
 */
public class ControladorApp {
    private ModeloUsuarios datos;
    
    public ControladorApp(){
        datos = new ModeloUsuarios();
    }
    public void agregarObservador(Observer ob){
        datos.addObserver(ob);
    }
    public void agregarUser(String x, String y, String z){
        datos.agregarUser(x,y,z);
    }
    public void eliminarUser(String name){
        datos.eliminarUser(name);
    }
    public HashMap getUsuarios(){
        return datos.getUsuarios();
    }
    public HashMap getTipo(){
        return datos.getTipoUser();
    }
}
