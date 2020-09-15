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

    /**
     *
     */
    public Respuesta(){
        
    }
    
    /**
     *
     * @param codigo
     * @param mensaje
     * @param objeto
     */
    public Respuesta(int codigo, String mensaje, Object objeto) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.objeto = objeto;
    }

    /**
     * Metodo para regresar codigo del error
     * @return Regresa el codigo de error
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Establece el codigo de error
     * @param codigo Codigo que se le asigna al error
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

     /**
     * Metodo para regresar mensaje del error
     * @return Regresa el mensaje de error
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Establece el mensaje de error
     * @param mensaje Mensaje que se le asigna al error
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Metodo para regresar objeto del error
     * @return Regresa el objeto de error
     */
    public Object getObjeto() {
        return objeto;
    }

    /**
     * Establece el objeto de error
     * @param objeto Objeto que se le asigna al error
     */
    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    @Override
    public String toString() {
        return "Respuesta{" + "codigo=" + codigo + ", mensaje=" + mensaje + ", objeto=" + objeto + '}';
    }
    
    
}
