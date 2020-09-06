/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.pojo;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class Materia implements Serializable{
    
    private int idMateria;
    
    private String nombreMateria;

    public Materia(){
        
    }
    
    public Materia(int idMateria, String nombreMateria) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", nombreMateria=" + nombreMateria + '}';
    }
    
    
    
    
    
}
