/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.pojo;

import java.io.Serializable;
import java.time.LocalTime;

/**
 *
 * @author ASUS-PC
 */
public class ErrorWrraper implements Serializable{
    
    private String error;
    
    private String codigo;
    
    private String nombreCodigo;
    
    private LocalTime fecha;

    public ErrorWrraper(String error, String codigo, String nombreCodigo) {
        this.error = error;
        this.codigo = codigo;
        this.nombreCodigo = nombreCodigo;
        this.fecha =  LocalTime.now();
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreCodigo() {
        return nombreCodigo;
    }

    public void setNombreCodigo(String nombreCodigo) {
        this.nombreCodigo = nombreCodigo;
    }

    public LocalTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalTime fecha) {
        this.fecha = fecha;
    }
    
    
        
    
}
