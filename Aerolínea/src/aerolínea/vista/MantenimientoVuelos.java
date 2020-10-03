/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.vista;

import aerolínea.controlador.ControladorAeroVue;
import aerolínea.modelo.ModeloAero;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Gonzalo
 */
public class MantenimientoVuelos extends JFrame implements Observer{
    public MantenimientoVuelos(ControladorAeroVue cntrl){
        super("Mantenimiento y administracion de vuelos");
        iniciadorComponentes();
        controlador=cntrl;
        //controlador.agregarObservador(this);
        this.setSize(900,900);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(true);
        this.setLayout(new BorderLayout());
        agregarComponentes(this.getContentPane());
        
    }
    public void iniciadorComponentes(){
        //panel superior ///////////////////////////////////////////////////////////////////////////
        Font font = new Font("Agency FB", Font.BOLD, 20);
        Font font1 = new Font("Agency FB", Font.BOLD, 20);
        superior=new JPanel();
        inferior=new JPanel();
        superior.setLayout(new GridBagLayout());
        superior.setBackground(Color.orange);
        inferior.setLayout(new FlowLayout());
        inferior.setBackground(Color.orange);
        modelo=new DefaultListModel();
        agregar=new JButton("Agregar");
        modificar=new JButton("Modificar");
        eliminar=new JButton("Eliminar");
        agregar.setFont(font);
        modificar.setFont(font);
        eliminar.setFont(font);
        numvuelo=new JTextField();
        lugsalida=new JTextField();
        lugllegada=new JTextField();
        fsalida=new JTextField();
        fllegada=new JTextField();
        hsalida=new JTextField();
        hllegada=new JTextField();
        cantas=new JTextField();
        numeroVue=new JLabel("Numero de vuelo");
        salida=new JLabel("Lugar de salida");
        llegada=new JLabel("Lugar de llegada");
        fechSalida=new JLabel("Fecha de salida");
        fechLlegada=new JLabel("Fecha de llegada");
        horSalida=new JLabel("Hora de salida");
        horLLegada=new JLabel("Hora de llegada");
        cantAsientos=new JLabel("Cantidad de asientos");
        numeroVue.setFont(font1);
        salida.setFont(font1);
        llegada.setFont(font1);
        fechSalida.setFont(font1);
        fechLlegada.setFont(font1);
        horSalida.setFont(font1);
        horLLegada.setFont(font1);
        cantAsientos.setFont(font1);
        tabla=new JTable();
        /* tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre ", "Fecha última de modificacion"
            }
        ));*/
        //jScrollPane1.setViewportView(tabla);
        
       // jScrollPane1.setViewportView(tabla);
        lista=new JList();
        lista.setVisibleRowCount(5);//sean visible 5
        lista.setFixedCellWidth(100);//alto y ancho
        lista.setFixedCellHeight(15);
       
        
    }
    public void agregarComponentes(Container e){
        
        GridBagConstraints ubicacion=new GridBagConstraints();
        ubicacion.insets=new Insets(15,15,15,15);
        
        ubicacion.gridx=0;
        ubicacion.gridy=0;
        ubicacion.gridwidth=1;
        ubicacion.gridheight=3;
        ubicacion.weightx=1.2;
        ubicacion.weighty=1.1;
        ubicacion.fill=GridBagConstraints.BOTH;
        superior.add(new JScrollPane(lista),ubicacion);
        
        ubicacion.gridy=3;
        ubicacion.gridheight=1;
        ubicacion.anchor=GridBagConstraints.EAST;
        ubicacion.fill=GridBagConstraints.NONE;
        superior.add(fechSalida,ubicacion);
        
        ubicacion.gridy=4;
        superior.add(fechLlegada,ubicacion);
        
        ubicacion.gridx=1;
        ubicacion.gridy=0;
        superior.add(numeroVue,ubicacion);
        
        ubicacion.gridy=1;
        superior.add(salida,ubicacion);
        
        ubicacion.gridy=2;
        superior.add(llegada,ubicacion);
        
        ubicacion.gridy=3;
        ubicacion.anchor=GridBagConstraints.CENTER;
        ubicacion.fill=GridBagConstraints.BOTH;
        superior.add(fsalida,ubicacion);
        
        ubicacion.gridy=4;
        superior.add(fllegada,ubicacion);
        
        ubicacion.gridy=5;
        ubicacion.anchor=GridBagConstraints.EAST;
        ubicacion.fill=GridBagConstraints.NONE;
        superior.add(cantAsientos,ubicacion);
        
        ubicacion.gridy=6;
        ubicacion.anchor=GridBagConstraints.WEST;
        ubicacion.fill=GridBagConstraints.BOTH;
        superior.add(agregar,ubicacion);
        
        ubicacion.gridx=2;
        ubicacion.gridy=0;
        ubicacion.anchor=GridBagConstraints.CENTER;
        superior.add(numvuelo,ubicacion);
        
        ubicacion.gridy=1;
        superior.add(lugsalida,ubicacion);
        
        ubicacion.gridy=2;
        superior.add(lugllegada,ubicacion);
        
        ubicacion.gridy=3;
        ubicacion.anchor=GridBagConstraints.EAST;
        ubicacion.fill=GridBagConstraints.NONE;
        superior.add(horSalida,ubicacion);
        
        ubicacion.gridy=4;
        superior.add(horLLegada,ubicacion);
        
        ubicacion.gridy=5;
        ubicacion.anchor=GridBagConstraints.CENTER;
        ubicacion.fill=GridBagConstraints.BOTH;
        superior.add(cantas,ubicacion);
        
        ubicacion.gridy=6;
        ubicacion.anchor=GridBagConstraints.WEST;
        superior.add(modificar,ubicacion);
        
        ubicacion.gridx=3;
        ubicacion.gridy=3;
        ubicacion.anchor=GridBagConstraints.CENTER;
        superior.add(hsalida,ubicacion);
        
        ubicacion.gridy=4;
        superior.add(hllegada,ubicacion);
        
        ubicacion.gridy=6;
        ubicacion.anchor=GridBagConstraints.WEST;
        superior.add(eliminar,ubicacion);
        
        e.add(superior,BorderLayout.NORTH);
        ////////////////////////////////////////iferior
        
        
    }
    public void list(String m){
      
        
    }
    
    private JPanel superior,inferior;
    private JButton agregar,modificar,eliminar;
    private JTextField numvuelo,lugsalida,lugllegada,fsalida,fllegada,hsalida,hllegada,cantas;
    private JLabel  numeroVue, salida,llegada,fechSalida,fechLlegada,horSalida,horLLegada,cantAsientos;
    private JList lista;
    private ControladorAeroVue controlador;
    private DefaultListModel modelo;
    private JTable tabla;
    private javax.swing.JScrollPane jScrollPane1;

    @Override
    public void update(Observable o, Object o1) {
        ModeloAero model = (ModeloAero)o;
         String vect[]=new String [model.getConjunto().size()];
         ArrayList<ModeloAero> temp=model.getConjunto();
         
         /*for(int i=0;i<model.getConjunto().size();i++){
               String nombre=temp.get(i).getNombre();
             System.out.println(nombre);
             System.out.println("");
          
             vect[i]=nombre;
            //model.get
         }*/
       //  for(int i=0;i<model.getConjunto().size();i++){
             modelo.addElement(temp);
             lista.setModel(modelo);
        // }
         //modelo.addElement(vect);
       
    }
}
    