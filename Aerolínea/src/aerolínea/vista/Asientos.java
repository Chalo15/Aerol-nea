/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.vista;


 

import java.awt.BorderLayout; 

import java.awt.Color; 
import java.awt.Container;

import java.awt.Font; 

import java.awt.GridLayout; 

import java.awt.event.ActionEvent; 

import java.awt.event.ActionListener; 

import javax.swing.AbstractButton; 

import javax.swing.JButton; 

import javax.swing.JFrame; 
import javax.swing.JOptionPane;

import javax.swing.JPanel; 

import javax.swing.JToggleButton; 

 

/** 

 * 

 * @author USER 

 */ 

public class Asientos extends JFrame { 

    private int rows =10; 
    private int columns=4 ; 
    private JButton aceptar;
    private Font font;
    private JPanel panel;
    private int val1,val2;
    private String[][] distribucion=new String[rows][columns];
    public String[][] getDistribucion() {
        return distribucion;
    }
public Asientos(){ 

        super("Reservar asientos"); 
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
         this.setSize(900, 600); 
        this.setLocationRelativeTo(null); 
         
        this.setLayout(new BorderLayout()); 
        iniciador(this.getContentPane());
        //distribucion=new String[rows][columns];

}
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

     

    
     
    public void iniciador(Container e){
        
         font = new Font("Arial", Font.BOLD, 20); 

        panel = new JPanel(new GridLayout(columns, rows)); 

        for (int row = 0; row < rows; row++) { 

            for (int column = 0; column < columns; column++) { 

                final JToggleButton button = new JToggleButton("Disponible"); 

                button.setBackground(Color.ORANGE); 

                button.setFont(font); 

                button.addActionListener(new ActionListener() { 

                    @Override 

                    public void actionPerformed(ActionEvent actionEvent) { 

                        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource(); 

                        boolean selected = abstractButton.getModel().isSelected(); 

                        if (selected) { 

                            button.setText("Reservado"); 
                         

                        abstractButton.setBackground(Color.LIGHT_GRAY); 
                        
                        

                        }  

                        else { 

                            button.setIcon(null); 

                        } 

                    } 

                }); 

                panel.add(button); 

            } 

        } 
       // distribucion[row][column]="O";
        aceptar = new JButton("Confirmar Campos"); 

        aceptar.setFont(font); 
        aceptar.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Asientos registrados","Registro", JOptionPane.INFORMATION_MESSAGE);
                dispose();
             }
         });
       

        e.add(panel, BorderLayout.CENTER); 

        e.add(aceptar, BorderLayout.SOUTH); 

        
    }

    public void init(){ 

        this.setVisible(true);

    } 

} 
/**
 *
 * @author Gonzalo
 */
