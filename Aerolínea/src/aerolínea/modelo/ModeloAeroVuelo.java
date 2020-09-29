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
public class ModeloAeroVuelo extends Observable {
    public ModeloAeroVuelo(){
        conjunto=new ArrayList<ModeloAeroVuelo>();
    }
    public ModeloAeroVuelo(String nom, Date fecha){
        this.nombre=nom;
        this.fecha=fecha;
    }

    public Date getFecha() {
        return fecha;
    }
    public void agregar(String nom,Date fecha){
        boolean estado=false;
        if(conjunto.isEmpty()){
             aero= new ModeloAeroVuelo(nom,fecha);
             conjunto.add(aero);
             this.setChanged();
             this.notifyObservers();
        }
        else{
            aero= new ModeloAeroVuelo(nom,fecha);
            if (!conjunto.contains(aero)){
                conjunto.add(aero);
                this.setChanged(); 
                this.notifyObservers();
            }
            
        }
        
    }
    
  
    public void modifi(String nom1, String nom2 ,Date fecha){
         for(int i=0;i<conjunto.size();i++){
            if(nom1==conjunto.get(i).getNombre()){
                aero=new ModeloAeroVuelo(nom2,fecha);
                conjunto.set(i, aero);
                this.setChanged(); 
                this.notifyObservers();
            }
        }
    }

    public ArrayList<ModeloAeroVuelo> getConjunto() {
        return conjunto;
    }

    public String getNombre() {
        return nombre;
    }
    
    private ArrayList<ModeloAeroVuelo> conjunto;
    private String nombre;
    private Date fecha;
    private ModeloAeroVuelo aero;
    
}
