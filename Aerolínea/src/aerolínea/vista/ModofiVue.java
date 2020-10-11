/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.vista;

import aerolínea.modelo.Vuelo;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Gonzalo
 */
public class ModofiVue extends JFrame{
    private JTextField numvuelo,lugsalida,lugllegada,fsalida,fllegada,hsalida,hllegada,cantas;
    private JLabel  numeroVue, salida,llegada,fechSalida,fechLlegada,horSalida,horLLegada,cantAsientos;
    private JButton aceptar;
    private String numvue,lugsali,lugllega,fsali,fllega,hsali,hllega,cant;
    private ModofiVue vuelo;
    
    public ModofiVue(){
        this.setSize(1000,1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(true);
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.orange);
        agregarComponentes(this.getContentPane());
        
    }

    public ModofiVue(String numvue, String lugsali, String lugllega, String fsali, String fllega, String hsali, String hllega, String cant) {
        this.numvue = numvue;
        this.lugsali = lugsali;
        this.lugllega = lugllega;
        this.fsali = fsali;
        this.fllega = fllega;
        this.hsali = hsali;
        this.hllega = hllega;
        this.cant = cant;
    }
    
    public void agregarComponentes(Container e){
         Font font = new Font("Agency FB", Font.BOLD, 20);
        Font font1 = new Font("Agency FB", Font.BOLD, 20);
        aceptar=new JButton("Aceptar");
        aceptar.setFont(font);
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
        
        GridBagConstraints ubicacion=new GridBagConstraints();
        ubicacion.insets=new Insets(15,15,15,15);
        
        ubicacion.gridx=0;
        ubicacion.gridy=0;
        ubicacion.gridwidth=1;
        ubicacion.gridheight=1;
        ubicacion.weightx=1.2;
        ubicacion.weighty=1.1;
        ubicacion.anchor=GridBagConstraints.EAST;
        ubicacion.fill=GridBagConstraints.HORIZONTAL;
        e.add(numeroVue,ubicacion);
        
 
        ubicacion.gridy=1;
        e.add(salida,ubicacion);
        
         ubicacion.gridy=2;
        e.add(llegada,ubicacion);
        
         ubicacion.gridy=3;
        e.add(fechSalida,ubicacion);
        
        ubicacion.gridy=4;
        e.add(fechLlegada,ubicacion);
        
        ubicacion.gridy=5;
        e.add(cantAsientos,ubicacion);
        
        
        ubicacion.gridx=1;
        ubicacion.gridy=0;
        ubicacion.anchor=GridBagConstraints.CENTER;
        e.add(numvuelo,ubicacion);
        
        ubicacion.gridy=1;
        e.add(lugsalida,ubicacion);
        
        ubicacion.gridy=2;
        e.add(lugllegada,ubicacion);
        
        ubicacion.gridy=3;
        e.add(fsalida,ubicacion);
        
        ubicacion.gridy=4;
        e.add(fllegada,ubicacion);
        
        ubicacion.gridy=5;
        e.add(cantas,ubicacion);
        
        
        ubicacion.gridx=2;
        ubicacion.gridy=0;
        ubicacion.anchor=GridBagConstraints.EAST;
        e.add(horSalida,ubicacion);
        
        ubicacion.gridy=1;
        e.add(horLLegada,ubicacion);
        
        ubicacion.gridy=2;
        e.add(aceptar,ubicacion);
        
         ubicacion.gridx=3;
        ubicacion.gridy=0;
        ubicacion.anchor=GridBagConstraints.CENTER;
        e.add(hsalida,ubicacion);
        
         ubicacion.gridy=1;
        e.add(hllegada,ubicacion);
        
        
        
        aceptar.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                 
               // String aerolinea,numvue,lugsali,lugllega,fsali,fllega,hsali,hllega,cant;
                
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
                try{
                     int prueba=Integer.parseInt(numvue);
                     prueba=Integer.parseInt(hsali);
                     prueba=Integer.parseInt(hllega);
                     prueba=Integer.parseInt(cant);
                      vuelo=new ModofiVue(numvue,lugsali,lugllega,fsali,fllega,hsali,hllega,cant);
             JOptionPane.showMessageDialog(null, "Se modificaron los datos del vuelo", "Informacion", JOptionPane.INFORMATION_MESSAGE);
             dispose();
             }
                catch(Exception e){
                     JOptionPane.showMessageDialog(null,"Debe de ingreassr un valor numerico en numero de vuelo, hora de salida, hora de llegada y en cantidad asientos","Error", JOptionPane.ERROR_MESSAGE);
                }
                }
             }
         });
    }

    public String getNumvue() {
        return numvue;
    }

    public String getLugsali() {
        return lugsali;
    }

    public String getLugllega() {
        return lugllega;
    }

    public String getFsali() {
        return fsali;
    }

    public String getFllega() {
        return fllega;
    }

    public String getHsali() {
        return hsali;
    }

    public String getHllega() {
        return hllega;
    }

    public String getCant() {
        return cant;
    }

    public ModofiVue getVuelo() {
        return vuelo;
    }

    
    
}
