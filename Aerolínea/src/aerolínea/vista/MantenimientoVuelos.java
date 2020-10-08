/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.vista;

import aerolínea.controlador.ControladorAeroVue;
import aerolínea.modelo.Aerolinea;
import aerolínea.modelo.ModeloAero;
import aerolínea.modelo.Vuelo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gonzalo
 */
public class MantenimientoVuelos extends JFrame implements Observer{
    public MantenimientoVuelos(ControladorAeroVue cntrl){
        super("Mantenimiento y administracion de vuelos");
        iniciadorComponentes();
        controlador=cntrl;
        this.setSize(1500,900);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(true);
        this.setLayout(new BorderLayout());
        agregarComponentes(this.getContentPane());
        
    }
    public void iniciadorComponentes(){
        //panel superior ///////////////////////////////////////////////////////////////////////////
       // nombre= new String("");
        //vect[]=new String [];
        
        Font font = new Font("Agency FB", Font.BOLD, 20);
        Font font1 = new Font("Agency FB", Font.BOLD, 20);
        superior=new JPanel();
        inferior=new JPanel();
        superior.setLayout(new GridBagLayout());
        superior.setBackground(Color.orange);
        inferior.setLayout(new GridBagLayout());
        
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
        
        lista=new JList(modelo);
        lista.setVisibleRowCount(5);//sean visible 5
        lista.setFixedCellWidth(100);//alto y ancho
        lista.setFixedCellHeight(15);
       
        //inferior///////////////////////////////////////////////////////////////////////////////////
        tabla=new JTable();
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null,null,null,null,null,null,null,null,null},
                {null, null,null,null,null,null,null,null,null,null},
                {null, null,null,null,null,null,null,null,null,null},
                {null, null,null,null,null,null,null,null,null,null},
                {null, null,null,null,null,null,null,null,null,null},
                {null, null,null,null,null,null,null,null,null,null},
                {null, null,null,null,null,null,null,null,null,null},
                {null, null,null,null,null,null,null,null,null,null},
                {null, null,null,null,null,null,null,null,null,null},             
                {null, null,null,null,null,null,null,null,null,null},
                {null, null,null,null,null,null,null,null,null,null},
                {null, null,null,null,null,null,null,null,null,null},
                {null, null,null,null,null,null,null,null,null,null},
                {null, null,null,null,null,null,null,null,null,null},
                {null, null,null,null,null,null,null,null,null,null},
                {null, null,null,null,null,null,null,null,null,null},
                {null, null,null,null,null,null,null,null,null,null},
                {null, null,null,null,null,null,null,null,null,null},
                
                
                
            },
            new String [] {
                "Aeroínea", "Numero de vuelo ","Lugar de salida","Lugar de llegada", "Fecha de salida","Fecha de llegada","Hora de salida","Hora de llegada","# asientos","Fecha última de modificación"
            }
        ));
        
        
        
        tabla.addMouseListener(new MouseAdapter() {
           DefaultTableModel model=new DefaultTableModel();
           public void mouseCliked(MouseEvent e){
               int i=tabla.getSelectedRow();
                dato0=tabla.getValueAt(i, 0).toString();
                dato1=tabla.getValueAt(i, 1).toString();
                dato2=tabla.getValueAt(i, 2).toString();
                dato3=tabla.getValueAt(i, 3).toString();
                dato4=tabla.getValueAt(i, 4).toString();
                dato5=tabla.getValueAt(i, 5).toString();
                dato6=tabla.getValueAt(i, 6).toString();
                dato7=tabla.getValueAt(i, 7).toString();
                dato8=tabla.getValueAt(i, 8).toString();
                dato9=tabla.getValueAt(i, 9).toString();
           }

        });
        
           
        
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
        
        split=new JSplitPane(JSplitPane.VERTICAL_SPLIT,superior,inferior);
        split.setOneTouchExpandable(true);
       
         
        ////////////////////////////////////////iferior
        
        ubicacion.insets=new Insets(30,30,150,30);
        
        ubicacion.gridx=0;
        ubicacion.gridy=0;
        inferior.add(new JScrollPane(tabla),ubicacion);
     agregarFuncionalidad();
        e.add(split,BorderLayout.CENTER);
    }
    public void list(String m){
      
        
    }
    
    public void agregarFuncionalidad(){
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String aerolinea,numvue,lugsali,lugllega,fsali,fllega,hsali,hllega,cant;
                aerolinea=String.valueOf(lista.getSelectedValue()); 
                numvue=numvuelo.getText();
                lugsali=lugsalida.getText();
                lugllega=lugllegada.getText();
                fsali=fsalida.getText();
                fllega=fllegada.getText();
                hsali=hsalida.getText();
                hllega=hllegada.getText();
                cant=cantas.getText();
                if( numvue.isEmpty()||lugsali.isEmpty()||lugllega.isEmpty()||fsali.isEmpty()||fllega.isEmpty()||hsali.isEmpty()||hllega.isEmpty()||cant.isEmpty()){
                   JOptionPane.showMessageDialog(null,"Ingrese todos los datos requeridos","Error", JOptionPane.WARNING_MESSAGE);
               }
                else{
                    fecha=new Date();
                    objvuelo=new Vuelo(aerolinea,numvue,lugsali,lugllega,fsali,fllega,hsali,hllega,cant,fecha);
                    controlador.accionVue(objvuelo);
                }
                numvuelo.setText("");
                lugsalida.setText("");
                lugllegada.setText("");
                fsalida.setText("");
                fllegada.setText("");
                hsalida.setText("");
                hllegada.setText("");
                cantas.setText("");
            }
        });
        
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                
                controlador.eliminarVue(dato1);
                
                
            }
        });
    }
    
    private JPanel superior,inferior;
    private JButton agregar,modificar,eliminar;
    private JTextField numvuelo,lugsalida,lugllegada,fsalida,fllegada,hsalida,hllegada,cantas;
    private JLabel  numeroVue, salida,llegada,fechSalida,fechLlegada,horSalida,horLLegada,cantAsientos;
    private JList lista;
    private ControladorAeroVue controlador;
    private DefaultListModel modelo;
    private JTable tabla;
    private JSplitPane split;
    private Vuelo objvuelo;
    private Date fecha;
    private String dato0,dato1,dato2,dato3,dato4,dato5,dato6,dato7,dato8,dato9;

    @Override
    public void update(Observable o, Object o1) {
        ModeloAero model = (ModeloAero)o;
        
        //actualizar lista con aerolineas existentes
         ArrayList<String> nombres=new ArrayList<String>();
         ArrayList<Aerolinea> temp=model.getConjunto();
        modelo.clear();
         int ent=0;
          for(Aerolinea i: temp){
           nombres.add(i.getNombre());
           modelo.add(ent,i.getNombre());
             //modelo.addElement(nombres);
             ent++;
       }
          
          //Actualziar tabla con vuelos creados
          String mat[][]=new String[model.getVuelos().size()][10];
           ArrayList<Vuelo> tempvue=model.getVuelos();
           
           for(int i=0;i<model.getVuelos().size();i++){
               mat[i][0]=tempvue.get(i).getAerolinea();
               mat[i][1]=tempvue.get(i).getNumerovuelo();
               mat[i][2]=tempvue.get(i).getLugarsalida();
               mat[i][3]=tempvue.get(i).getLugarllegada();
               mat[i][4]=tempvue.get(i).getFechasalida();
               mat[i][5]=tempvue.get(i).getFechallegada();
               mat[i][6]=tempvue.get(i).getHorasalida();
               mat[i][7]=tempvue.get(i).getHorallegada();
               mat[i][8]=tempvue.get(i).getCantidadasientos();
               mat[i][9]=String.valueOf(tempvue.get(i).getFecha());
               
               
           }
           tabla.setModel(new javax.swing.table.DefaultTableModel(
                        mat
                   ,
            new String [] {
               "Aeroínea", "Numero de vuelo ","Lugar de salida","Lugar de llegada", "Fecha de salida","Fecha de llegada","Hora de salida","Hora de llegada","# asientos","Fecha última de modificación"
            }
        ));
        // lista.setModel(modelo);

       
    }
}
    