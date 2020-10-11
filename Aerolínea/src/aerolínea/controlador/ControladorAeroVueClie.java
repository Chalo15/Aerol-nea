/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.controlador;

import aerolínea.modelo.Aerolinea;
import aerolínea.modelo.Arreglos;
import aerolínea.modelo.Cliente;
import aerolínea.modelo.Vuelo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author Gonzalo
 */
public class ControladorAeroVueClie {
    private Arreglos modelo;
    private Vuelo vuelo;
    private Aerolinea aerolinea;
    private Cliente cliente;
    
    public ControladorAeroVueClie(){
        modelo=new Arreglos();
    }
    public void agregarObservador(Observer vis){
        modelo.addObserver(vis);
    }
    public void accionAero(String dato,Date fecha){
       aerolinea=new Aerolinea(dato,fecha);
            modelo.agregar(aerolinea);
        
    }
    public void accionVue(String aerolinea,String numvue,String lugsali,String lugllega,String fsali,String fllega,String hsali,String hllega,String cant,Date fecha){
       vuelo=new Vuelo(aerolinea,numvue,lugsali,lugllega,fsali,fllega,hsali,hllega,cant,fecha);
            modelo.agregar(vuelo);
        
    }
    public void accionClien(String ced,String nom,String ape1,String ape2,int cant, String numvue){
        cliente=new Cliente(ced,nom,ape1,ape2,cant,numvue);
        modelo.agregar(cliente);
        
    }
    public void cambio(String dato1,String cambio,Date fecha){
        aerolinea=new Aerolinea(cambio,fecha);
        modelo.modifi(dato1,aerolinea);
    }
    public void eliminarVue(String num){
        modelo.eliminarVue(num);
    }
    public Boolean busqueda(String nom,String id){
        if(modelo.busquedaClie(nom,id)){
            return true;
        }
        else{return false;}
    }
    public void mostrarClie(String id){
        ArrayList<Cliente> list=modelo.getClientes();
            for(int i=0;i<modelo.getClientes().size();i++){
            if(list.get(i).getCedula().equals(id)){
                JOptionPane.showMessageDialog(null, list.get(i).toString(), "Información",JOptionPane.INFORMATION_MESSAGE);
            }            
        }  
    }
    public void modifiVue(String dato1,String aerolinea,String numvue,String lugsali,String lugllega,String fsali,String fllega,String hsali,String hllega,String cant,Date fecha){
         vuelo=new Vuelo(aerolinea,numvue,lugsali,lugllega,fsali,fllega,hsali,hllega,cant,fecha);
        modelo.modifiVue(dato1, vuelo);
    }
}
