/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.vista;

import aerolínea.controlador.ControladorAeroVueClie;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Gonzalo
 */
public class InterfazPrincipal extends JFrame  {
    private JPanel principal;
    private JButton configuracionApp,mantenimientoClientes,mantenimientoVuelos,mantenimientoAerolineas;
    private JLabel mensaje;
    private MantenimientoAerolinea aerolineas;
    private MantenimientoVuelos vuelos;
    private ConfigApp configuracion;
    private MantenimientoClientes clientes;
    private boolean estado;
    
    private ControladorAeroVueClie control;
    
    public  InterfazPrincipal(boolean est){
        super("Interfaz Principal");
           init();
           this.estado=est;
           control=new ControladorAeroVueClie();
           aerolineas=new MantenimientoAerolinea(control);
           vuelos=new MantenimientoVuelos(control);
           configuracion=new ConfigApp();
           clientes=new MantenimientoClientes(control);
           control.agregarObservador(aerolineas);
           control.agregarObservador(vuelos);
           control.agregarObservador(clientes);
        Font font = new Font("Agency FB", Font.BOLD, 24);
        Font font1 = new Font("Agency FB", Font.BOLD, 34);
        principal=new JPanel();
        configuracionApp=new JButton("Configuración de la apicación");
        mantenimientoClientes=new JButton("Mantenimiento y administración de clientes");
        mantenimientoVuelos= new JButton("Mantenimiento y administración de vuelos");
        mantenimientoAerolineas=new JButton("Mantenimiento y administración de aerolineas");
        mensaje=new JLabel("Menu principal");
        
        configuracionApp.setFont(font);
        mantenimientoClientes.setFont(font);
        mantenimientoVuelos.setFont(font);
        mantenimientoAerolineas.setFont(font);
        mensaje.setFont(font1);
        principal.setBackground(Color.orange);
        
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
        
        principal.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(20,20,20,20);
        
        constraints.gridx = 0;   // Primera columna
        constraints.gridy = 0;   // Primera fila
        constraints.weightx = 0.5;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.NORTH;
        principal.add(mensaje, constraints);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridwidth = 0;
        
        
        constraints.gridy = 1;   // Primera fila
        constraints.weightx = 0.5;
        constraints.fill = GridBagConstraints.BOTH;
        principal.add(configuracionApp, constraints);
        
        constraints.gridy = 2;   // Segunda fila
        constraints.fill = GridBagConstraints.BOTH;
        principal.add(mantenimientoVuelos, constraints);
        
        constraints.gridy = 4;
        constraints.fill = GridBagConstraints.BOTH;
        principal.add(mantenimientoAerolineas, constraints);
        
        constraints.gridy = 5;
        constraints.fill = GridBagConstraints.BOTH;
        principal.add(mantenimientoClientes, constraints);
        
        AgregarFuncionalidad();
        
        c.add(principal, BorderLayout.CENTER);
        
    }
    //Falta ver cuales menus requieren ver si es admin o no
    public void AgregarFuncionalidad(){
        configuracionApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //configuracion.setVisible();
                 if(estado){
                     configuracion.setVisible(true);                 
                }
                else{
                    JOptionPane.showMessageDialog(null, "No posee permisos de administrador");
                }
            }
        });
                
        mantenimientoClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clientes.setVisible(true);
            }
        });
               
        mantenimientoVuelos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //vuelos.setVisible();
                 if(estado){
                  vuelos.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "No posee permisos de administrador");
                }
            }
        });
                
        mantenimientoAerolineas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(estado){
                    aerolineas.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "No posee permisos de administrador");
                }
            }
        });
                
       
        
    }

  
}
