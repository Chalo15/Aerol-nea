/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.modelo;

import java.util.HashMap;
import java.util.Observable;

/**
 *
 * @author Pablo Lizano
 */
public class ModeloUsuarios extends Observable {
    HashMap usuarios = new HashMap();
    HashMap tipoUser = new HashMap();
    boolean acceso, type;
    boolean existekey, existevalue;

    public boolean isAcceso() {
        return acceso;
    }

    public boolean isType() {
        return type;
    }
    
    
    public ModeloUsuarios(){
        usuarios.put("gonzaloumana", "123gonza");
        tipoUser.put("gonzaloumana", "1");
        usuarios.put("pablolizano", "754cuadra");
        tipoUser.put("pablolizano", "1");
        usuarios.put("user", "user");
        tipoUser.put("user", "0");
    }
    
    public void agregarUser(String nom, String con, String tipo){
        if(!usuarios.containsKey(nom)){
            usuarios.put(nom, con);
            tipoUser.put(nom, tipo); 
        }
    }
    public void ValidarUser(String nom, String contr){ 
        existekey = usuarios.containsKey(nom);
        existevalue = usuarios.containsValue(contr);
        if(existekey == true && existevalue == true){
            acceso = true;
            
            String admin = tipoUser.get(nom).toString();
            if(admin == "1"){
                type = true;               
            }
            else{
                type = false;  
            }
                    this.setChanged();   
            this.notifyObservers();      
        }
        else{
            acceso = false;
            type = false;
            this.setChanged();   
            this.notifyObservers(); 
        }
    }     
}
