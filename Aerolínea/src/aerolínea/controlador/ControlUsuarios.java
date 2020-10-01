/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.controlador;

import aerolínea.modelo.ModeloUsuarios;
import java.util.Observer;

/**
 *
 * @author USER
 */
public class ControlUsuarios {
    private ModeloUsuarios data;
    
    public ControlUsuarios(){
        data = new ModeloUsuarios();
    }
    
    public void agregarObservador(Observer obs){
        data.addObserver(obs);
    }
    
    public void Verificar(String nom, String contr){
        data.ValidarUser(nom, contr);
    }     
}
