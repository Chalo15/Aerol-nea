/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.vista;

import aerolínea.controlador.ControladorApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class ConfigApp extends JFrame implements Observer {
    JLabel etiq1;
    JLabel etiq2;
    JLabel etiq3;
    JTextField text1;
    JTextField text2;
    JButton agregar;
    JButton eliminar;
    JCheckBox admin;
    JCheckBox clien;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabla;
    private String [] nameColums = {"Usuarios", "Contrasena", "Rol"};
    private String [][] filas = {{"gonzaloumana","123gonza", "1"},
        {"pablolizano","754cuadra","1"},
        {"user","user","0"}
    };
    ControladorApp control;
    String datoUser;
    int i = 0;
    
    public ConfigApp(){
        super("Configuracion Aplicacion");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        
        control = new ControladorApp();
        control.agregarObservador(this);
        etiq1 = new JLabel("Usuario");
        etiq2 = new JLabel("Contraseña");
        etiq3 = new JLabel("Rol: ");
        text1 = new JTextField(" ");
        text2 = new JTextField(" ");
        agregar = new JButton("Agregar");
        eliminar = new JButton("Eliminar");
        admin = new JCheckBox("Administrador");
        clien = new JCheckBox("Cliente");
        tabla = new JTable(filas, nameColums);
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().setBackground(Color.ORANGE);
        this.agregarComponentes(this.getContentPane());
    }
    public void iniciar(){
        this.setVisible(true);
    }
    public void agregarComponentes(Container c){
        Font font2 = new Font("Agency FB", Font.PLAIN, 30);
        
        JPanel principal = new JPanel(new GridBagLayout());
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        
        constraints.gridx = 0; // El área de texto empieza en la columna cero.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.weightx = 0.0;
        constraints.fill = GridBagConstraints.NONE;
        etiq1.setFont(font2);
        principal.add(etiq1, constraints);
        
        constraints.gridy = 1; // El área de texto empieza en la fila cero
        constraints.weightx = 0.2;
        constraints.fill = GridBagConstraints.BOTH;
        text1.setFont(font2);
        principal.add(text1, constraints);
        
        constraints.gridx = 1; // El área de texto empieza en la columna cero.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.weightx = 0.0;
        constraints.fill = GridBagConstraints.NONE;
        etiq2.setFont(font2);
        principal.add(etiq2, constraints);
        
        constraints.gridy = 1; // El área de texto empieza en la fila cero
        constraints.weightx = 0.2;
        constraints.fill = GridBagConstraints.BOTH;
        text2.setFont(font2);
        principal.add(text2, constraints);
        
        constraints.gridx = 2; // El área de texto empieza en la columna cero.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.fill = GridBagConstraints.NONE;
        etiq3.setFont(font2);
        principal.add(etiq3, constraints);
        
        constraints.gridy = 1; // El área de texto empieza en la fila cero
        admin.setFont(font2);
        principal.add(admin, constraints);
        
        constraints.gridy = 2; // El área de texto empieza en la fila cero
        clien.setFont(font2);
        principal.add(clien, constraints);
        
        constraints.gridx = 0; // El área de texto empieza en la columna cero.
        constraints.gridy = 3; // El área de texto empieza en la fila cero
        constraints.gridwidth = 2;
        agregar.setFont(font2);
        principal.add(agregar, constraints);
        
        constraints.gridx = 1; // El área de texto empieza en la columna cero.
        constraints.gridy = 3; // El área de texto empieza en la fila cero
        eliminar.setFont(font2);
        principal.add(eliminar, constraints);    
        
        c.add(principal, BorderLayout.NORTH);
        c.add(new JScrollPane(tabla), BorderLayout.CENTER);
        
        agregar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(admin.isSelected()== false&&clien.isSelected()==false || admin.isSelected()==true&&clien.isSelected()==true){
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un unico rol");
                }
                else{
                    String nom = text1.getText();
                    String pas = text2.getText();
                    String rol = "0";
                    if(admin.isSelected()==true && clien.isSelected()==false){
                        rol = "1";
                    }
                    else if(clien.isSelected()==true && admin.isSelected()==false){
                        rol = "0";
                    }
                    text1.setText(" ");
                    text2.setText(" ");
                    admin.setSelected(false);
                    clien.setSelected(false);
                    control.agregarUser(nom, pas, rol);
                }
            }
            
        });
        
        eliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                i = tabla.getSelectedRow();
                if(i==-1){
                    JOptionPane.showMessageDialog(null, "Debe marcar una fila primero");
                }
                else{
                    datoUser=tabla.getValueAt(i, 0).toString();  
                    control.eliminarUser(datoUser);
                }
            }        
        });
    }

    @Override
    public void update(Observable o, Object o1) {
        ArrayList<String> usuario=new ArrayList<String>(control.getUsuarios().keySet());
        ArrayList<String> contra=new ArrayList<String>(control.getUsuarios().values());
        ArrayList<String> roles=new ArrayList<String>(control.getTipo().values());
        
        String mat[][]=new String[usuario.size()][3];
        for(int i=0;i<usuario.size();i++){
               mat[i][0]= usuario.get(i);
               mat[i][1] = contra.get(i);
               mat[i][2] = roles.get(i);              
        }
        
        tabla.setModel(new javax.swing.table.DefaultTableModel(
                        mat, nameColums
        ));
    }
    
}
