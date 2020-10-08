/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolínea.modelo;

import java.util.Date;

/**
 *
 * @author Gonzalo
 */
public class Vuelo {
    
    public Vuelo(String aero,String num,String lugs,String lugll,String fsali,String fllega,String hsali,String hllega,String cant,Date fech){
        this.aerolinea=aero;
        this.numerovuelo=num;
        this.lugarsalida=lugs;
        this.lugarllegada=lugll;
        this.fechasalida=fsali;
        this.fechallegada=fllega;
        this.horasalida=hsali;
        this.horallegada=hllega;
        this.cantidadasientos=cant;
        this.fecha=fech;
        
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getNumerovuelo() {
        return numerovuelo;
    }

    public void setNumerovuelo(String numerovuelo) {
        this.numerovuelo = numerovuelo;
    }

    public String getLugarsalida() {
        return lugarsalida;
    }

    public void setLugarsalida(String lugarsalida) {
        this.lugarsalida = lugarsalida;
    }

    public String getLugarllegada() {
        return lugarllegada;
    }

    public void setLugarllegada(String lugarllegada) {
        this.lugarllegada = lugarllegada;
    }

    public String getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(String fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getFechallegada() {
        return fechallegada;
    }

    public void setFechallegada(String fechallegada) {
        this.fechallegada = fechallegada;
    }

    public String getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(String horasalida) {
        this.horasalida = horasalida;
    }

    public String getHorallegada() {
        return horallegada;
    }

    public void setHorallegada(String horallegada) {
        this.horallegada = horallegada;
    }

    public String getCantidadasientos() {
        return cantidadasientos;
    }

    public void setCantidadasientos(String cantidadasientos) {
        this.cantidadasientos = cantidadasientos;
    }
    
    
   private String aerolinea,numerovuelo,lugarsalida,lugarllegada,fechasalida,fechallegada,horasalida,horallegada,cantidadasientos;
   private Date fecha;
}
