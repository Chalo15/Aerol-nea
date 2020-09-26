/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Gonzalo
 */
public class MantenimientoAerolineas extends JFrame{
    private JButton agregar,modificar;
    private JLabel info;
    private JTextField nombre;
    private JTable cuadro;
    
    public MantenimientoAerolineas(){
        agregar= new JButton("Agregar");
        modificar=new JButton("Modificar");
        info=new JLabel("Ingrese el nombre");
        nombre=new JTextField();
        cuadro=new JTable();
    }
    
    
    
}
