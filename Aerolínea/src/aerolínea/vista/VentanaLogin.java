/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.vista;

import aerolínea.vista.InterfazPrincipal;
import aerolínea.controlador.ControlUsuarios;
import aerolínea.modelo.ModeloUsuarios;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Pablo Lizano
 */
public class VentanaLogin extends JFrame implements Observer {
    JLabel etiq1;
    JLabel etiq2;
    JTextField campo1;
    JTextField campo2;
    JButton login;
    ControlUsuarios gestor;
    
    public VentanaLogin(){
        gestor = new ControlUsuarios();
        gestor.agregarObservador(this);
        this.setSize(550,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        
        etiq1 = new JLabel("Usuario:");
        etiq2 = new JLabel("Contraseña:");
        campo1 = new JTextField("");
        campo1.setSize(10, 10);
        campo2 = new JTextField("");
        login = new JButton("Ingresar");
        
        this.getContentPane().setLayout(new GridBagLayout());
        this.agregarComponentes(this.getContentPane());
    }
    public void iniciar(){
        this.setVisible(true);
    }
    public void agregarComponentes(Container c){
        Font font = new Font("Agency FB", Font.BOLD, 30);
        Font font2 = new Font("Agency FB", Font.PLAIN, 30);
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(20, 20, 20, 20);
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.0;
        constraints.fill = GridBagConstraints.NONE;
        etiq1.setFont(font);
        c.add(etiq1, constraints);
        
        constraints.gridx = 1;
        constraints.weightx = 0.2;
        constraints.fill = GridBagConstraints.BOTH;
        campo1.setFont(font2);
        c.add(campo1, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.0;
        constraints.fill = GridBagConstraints.NONE;
        etiq2.setFont(font);
        c.add(etiq2, constraints);
        
        constraints.gridx = 1;
        constraints.weightx = 0.2;
        constraints.fill = GridBagConstraints.BOTH;
        campo2.setFont(font2);
        c.add(campo2, constraints);
        
        c.add(new Box.Filler(
                new Dimension(0, 0),
                new Dimension(0, 0),
                new Dimension(0, Integer.MAX_VALUE)), constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 3; 
        constraints.gridwidth = 2; 
        constraints.weightx = 0.1;
        constraints.weightx = 0.0;
        constraints.fill = GridBagConstraints.CENTER;
        login.setFont(font);
        c.add (login, constraints);
        
        login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                gestor.Verificar(campo1.getText(), campo2.getText());
            }          
        });
        
    }  

    @Override
    public void update(Observable o, Object o1) {
        ModeloUsuarios m = (ModeloUsuarios)o;
      //  boolean access = m.isAcceso();
       // boolean tipo = m.isType();
        
        if(m.isAcceso() == true){       
            if(m.isType()){
            InterfazPrincipal inst = new InterfazPrincipal(true);
            inst.setVisible(true);
            dispose();
            }
            else{
             InterfazPrincipal inst = new InterfazPrincipal(false);
             inst.setVisible(true);
             dispose();
            }
            
        }
        else if(m.isAcceso() == false) {
            JOptionPane.showMessageDialog(null, "Datos Errones");
        }
    }
}
