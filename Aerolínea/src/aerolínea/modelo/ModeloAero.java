/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import javax.swing.JOptionPane;

/**
 *
 * @author Gonzalo
 */
public class ModeloAero extends Observable {
    public ModeloAero(){
        conjunto=new ArrayList<Aerolinea>();
        vuelos=new ArrayList<Vuelo>();
    }
    

    public Date getFecha() {
        return fecha;
    }
    public void agregar(Vuelo vue){
        boolean estado=false;
        if(vuelos.isEmpty()){
            vuelos.add(vue);
             this.setChanged();
             this.notifyObservers();
        }
        else{
            for(int i=0;i<vuelos.size();i++){
                if(vuelos.get(i).getNumerovuelo().equals(vue.getNumerovuelo())){
                    estado=true;
                     JOptionPane.showMessageDialog(null,"Vuelo ya existente","Error", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                    
            }
            if(!estado){
                vuelos.add(vue);
                this.setChanged();
                 this.notifyObservers();
            }
        }
    }
    public void agregar(Aerolinea aero){
        boolean estado=false;
        if(conjunto.isEmpty()){
             conjunto.add(aero);
             this.setChanged();
             this.notifyObservers();
        }
        else{
            
            for(int i=0;i<conjunto.size();i++){
                //estado=conjunto.get(i).getNombre().equals(aero.getNombre());
               if(conjunto.get(i).getNombre().equals(aero.getNombre())){
                estado=true;
                JOptionPane.showMessageDialog(null,"Aerolinea ya existente","Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
            if (!estado){
                conjunto.add(aero);
                this.setChanged(); 
                this.notifyObservers();
            }
           
        }
        
    }
    
  
    public void modifi(String nom1, Aerolinea aero){//modificar
         for(int i=0;i<conjunto.size();i++){
            if(nom1==conjunto.get(i).getNombre()){
                conjunto.set(i, aero);
                this.setChanged(); 
                this.notifyObservers();
            }
        }
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(ArrayList<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public ArrayList<Aerolinea> getConjunto() {
        return conjunto;
    }

    public String getNombre() {
        return nombre;
    }
    public void eliminarVue(String num){
        for(int i=0;i<vuelos.size();i++){
            if(num.equals(vuelos.get(i).getNumerovuelo())){
               // vuelos.remove(i);
                vuelos.remove(vuelos.get(i));
                this.setChanged(); 
                this.notifyObservers();
            }
        }
    }
    
    private ArrayList<Aerolinea> conjunto;
    private ArrayList<Vuelo> vuelos;
    private String nombre;
    private Date fecha;
   // private ModeloAero aero;
    
}
