/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gonzalo
 */
public class InterfazPrincipal extends JFrame  {
    private JPanel principal;
    private JButton configuracionApp,mantenimientoClientes,mantenimientoVuelos,mantenimientoAerolineas;
    private JLabel mensaje;
    //private MantenimientoAerolineas aerolineas;
    //private MantenimientoVuelos vuelos;
    //private ConfiguracionAplicacion configuracion;
    //private MantenimientoClientes clientes;
    
    public  InterfazPrincipal(){
           init();
           /*
           aerolineas=new MantenimientoAerolineas();
           vuelos=new MantenimientoVuelos();
           configuracion=new ConfiguracionAplicacion();
           clientes=new MantenimientoClientes();
           */
        principal=new JPanel();
        configuracionApp=new JButton("Configuración de la apicación");
        mantenimientoClientes=new JButton("Mantenimiento y administración de clientes");
        mantenimientoVuelos= new JButton("Mantenimiento y administración de vuelos");
        mantenimientoAerolineas=new JButton("Mantenimiento y administración de aerolineas");
        mensaje=new JLabel("Menu principal");
        this.setLayout(new BorderLayout());
     
        AgregarComponentes(this.getContentPane());
        
    }
    public void init(){
        this.setSize(500,500);
        //this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void AgregarComponentes(Container c){
        
        principal.setLayout(new GridLayout(5,1,0,6));
        principal.add(mensaje);
        principal.add(configuracionApp);
        principal.add(mantenimientoVuelos);
        principal.add(mantenimientoAerolineas);
        principal.add(mantenimientoClientes);
        AgregarFuncionalidad();
       // c.add(mensaje,BorderLayout.NORTH);
        c.add(principal,BorderLayout.CENTER);
        
    }
    
    public void AgregarFuncionalidad(){
        configuracionApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //configuracion.setVisible();
            }
        });
                
        mantenimientoClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //clientes.setVisible();
            }
        });
               
        mantenimientoVuelos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //vuelos.setVisible();
            }
        });
                
        mantenimientoAerolineas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               //aerolineas.setVisible();
            }
        });
                
       
        
    }

  
}
