/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.pojo;

/**
 *
 * @author Asus
 */
public class Respuesta {
    
    private int codigo;
    
    private String mensaje;
    
    private Object objeto;

    
    public Respuesta(){
        
    }
    
    public Respuesta(int codigo, String mensaje, Object objeto) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.objeto = objeto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    @Override
    public String toString() {
        return "Respuesta{" + "codigo=" + codigo + ", mensaje=" + mensaje + ", objeto=" + objeto + '}';
    }
    
    
}
