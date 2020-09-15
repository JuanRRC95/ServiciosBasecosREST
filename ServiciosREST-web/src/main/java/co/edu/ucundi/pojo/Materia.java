/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.pojo;

import java.io.Serializable;

/**
 *
 * @author Juan Ricardo Rodríguez, Santiago Gómez
 */
public class Materia implements Serializable{
    
    private int idMateria;
    
    private String nombreMateria;

    /**
     *
     */
    public Materia(){
        
    }
    
    /**
     *
     * @param idMateria
     * @param nombreMateria
     */
    public Materia(int idMateria, String nombreMateria) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
    }

   /**
     * Metodo para regresar la id de la materia del profesor
     * @return Regresa el id de la  materia del profesor
     */
    public int getIdMateria() {
        return idMateria;
    }

    /**
     * Establece el id de la materia del profesor
     * @param idMateria Materias que se le asignara al profesor
     */
    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

     /**
     * Metodo para regresar el nombre de la materia del profesor
     * @return Regresa el nombre de la  materia del profesor
     */
    public String getNombreMateria() {
        return nombreMateria;
    }

    /**
     * Establece el nombre de la materia del profesor
     * @param nombreMateria Nombre que se le asignara a la materia
     */
    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", nombreMateria=" + nombreMateria + '}';
    }
    
    
    
    
    
}
