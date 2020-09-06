/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.pojo;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.*;

/**
 *
 * @author Asus
 */
public class Profesor implements Serializable{
    
   // @NotNull
  //  @Size(min=2, max=240,message = "Nombre invalido")
    private String nombre;
    
  //  @NotNull
  //  @Size(min=2, max=240,message = "Nombre invalido")
    private String apellido;
    
   // @Min(value=18,message = "La edad debe ser mayor o igual a los 18 años")
    private int edad;
    
//    @Max(value=2000000000,message = "Cedula incorrecta")
    private int cedula;
    
 //   @NotNull
//    @Size(min=2, max=240,message = "Nombre invalido")
    private List<String> materia;

    public Profesor(){
        
    }
    
    
    public Profesor(String nombre, String apellido, int edad, int cedula, List<String> materia) {       
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cedula = cedula;
        this.materia = materia;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public List<String> getMaterias() {
        return materia;
    }

    public void setMaterias(List<String> materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Profesor{" + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", cedula=" + cedula + ", materia=" + materia + '}';
    }
    
    
    
    
    
}
