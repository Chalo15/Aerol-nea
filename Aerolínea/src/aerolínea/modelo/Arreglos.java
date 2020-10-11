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
public class Arreglos extends Observable {
    public Arreglos(){
        conjunto=new ArrayList<Aerolinea>();
        vuelos=new ArrayList<Vuelo>();
        clientes=new ArrayList<Cliente>();
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
    
    public void agregar(Cliente cli){
         boolean estado=false;
        if(clientes.isEmpty()){
             clientes.add(cli);
             this.setChanged();
             this.notifyObservers();
        }
        else{
            
            for(int i=0;i<conjunto.size();i++){              
               if(clientes.get(i).getCedula().equals(cli.getCedula())){
                estado=true;
                clientes.get(i).setCantidad(cli.getCantidad());
                JOptionPane.showMessageDialog(null,"Cliente actualizado","Actualización", JOptionPane.INFORMATION_MESSAGE);
                this.setChanged(); 
                this.notifyObservers();
                return;
            }
        }
            if (!estado){
                clientes.add(cli);
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
    public void modifiVue(String num, Vuelo vue){
         for(int i=0;i<vuelos.size();i++){
            if(num==vuelos.get(i).getNumerovuelo()){
                vuelos.set(i, vue);
                this.setChanged(); 
                this.notifyObservers();
            }
        }
    }
    
    public void eliminarVue(String num){
        for(int i=0;i<vuelos.size();i++){
            if(num==vuelos.get(i).getNumerovuelo()){
                vuelos.remove(i);
                this.setChanged(); 
                this.notifyObservers();
            }
        }
    }
    
    public Boolean busquedaClie(String nom, String id){
        boolean estado=false;
        for(int i=0;i<clientes.size();i++){
        if(clientes.get(i).getNombre().equals(nom)||clientes.get(i).getCedula().equals(id)){
            estado=true;
            return true;
        }
        else{
            estado=false;
            return false;
        }
        }
        return estado;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
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
    public Date getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    private ArrayList<Aerolinea> conjunto;
    private ArrayList<Vuelo> vuelos;
    private ArrayList<Cliente> clientes;
    private String nombre;
    private Date fecha;
   
    
}
