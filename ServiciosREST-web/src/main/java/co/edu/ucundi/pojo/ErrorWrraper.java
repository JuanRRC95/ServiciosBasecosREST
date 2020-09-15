/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.pojo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Santiago Gómez Caicedo
 * @author Juan Ricardo Rodríguez
 */
public class ErrorWrraper implements Serializable {

    private String error;
    private String descripcion;
    private String mensajeApp;
    private StackTraceElement[] trace;
    private LocalDate fecha;
    private Status codigo;

    public ErrorWrraper() {
    }

    public ErrorWrraper(String error, String descripcion, String mensajeApp, StackTraceElement[] trace, LocalDate fecha, Status codigo) {
        this.error = error;
        this.descripcion = descripcion;
        this.mensajeApp = mensajeApp;
        this.trace = trace;
        this.fecha = fecha;
        this.codigo=codigo;
    }

    public ErrorWrraper(String error, String descripcion, String mensajeApp, StackTraceElement[] trace, LocalDate fecha) {
        this.error = error;
        this.descripcion = descripcion;
        this.mensajeApp = mensajeApp;
        this.trace = trace;
        this.fecha = fecha;
    }

    
    public Status getCodigo() {
        return codigo;
    }

    public void setCodigo(Status codigo) {
        this.codigo = codigo;
    }

    public String getMensajeApp() {
        return mensajeApp;
    }

    public void setMensajeApp(String mensajeApp) {
        this.mensajeApp = mensajeApp;
    }

    

    public StackTraceElement[] getTrace() {
        return trace;
    }

    public void setTrace(StackTraceElement[] trace) {
        this.trace = trace;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


   

  

}
