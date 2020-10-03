/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

/**
 *
 * @author Gonzalo
 */
public class ModeloAero extends Observable {
    public ModeloAero(){
        conjunto=new ArrayList<ModeloAero>();
    }
    public ModeloAero(String nom, Date fecha){
        this.nombre=nom;
        this.fecha=fecha;
    }

    public Date getFecha() {
        return fecha;
    }
    public void agregar(String nom,Date fecha){//
        boolean estado=false;
        if(conjunto.isEmpty()){
             aero= new ModeloAero(nom,fecha);
             conjunto.add(aero);
             this.setChanged();
             this.notifyObservers();
        }
        else{
            aero= new ModeloAero(nom,fecha);
            int tamanio=conjunto.size();
            for(int i=0;i<conjunto.size();i++){
            if(conjunto.get(i).getNombre()==nom){
                estado=true;
            }
        }
            if (!estado){
                conjunto.add(aero);
                this.setChanged(); 
                this.notifyObservers();
            }
           
        }
        
    }
    
  
    public void modifi(String nom1, String nom2 ,Date fecha){
         for(int i=0;i<conjunto.size();i++){
            if(nom1==conjunto.get(i).getNombre()){
                aero=new ModeloAero(nom2,fecha);
                conjunto.set(i, aero);
                this.setChanged(); 
                this.notifyObservers();
            }
        }
    }

    public ArrayList<ModeloAero> getConjunto() {
        return conjunto;
    }

    public String getNombre() {
        return nombre;
    }
    
    private ArrayList<ModeloAero> conjunto;
    private String nombre;
    private Date fecha;
    private ModeloAero aero;
    
}
