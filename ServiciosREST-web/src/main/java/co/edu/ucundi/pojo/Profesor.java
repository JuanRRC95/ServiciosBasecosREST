package co.edu.ucundi.pojo;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.*;

/**
 * Clase que contiene los metodos get y set de la clase Profesor.
 * @since ServiciosREST 1.0
 * @version 1.0
 * @author Juan Ricardo Rodriguez Campos
 * @author Santiago Gomez Caicedo
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
    
    private String correo;
    
 //   @NotNull
//    @Size(min=2, max=240,message = "Nombre invalido")
    private List<String> materia;

    /**
     * 
     */
    public Profesor(){
        
    }
    
    /**
     * Contructor de la clase
     * @param nombre
     * @param apellido
     * @param edad
     * @param cedula
     * @param materia
     * @param correo 
     */
    public Profesor(String nombre, String apellido, int edad, int cedula, List<String> materia,String correo) {       
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cedula = cedula;
        this.materia = materia;
        this.correo=correo;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Profesor{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", cedula=" + cedula + ", correo=" + correo + ", materia=" + materia + '}';
    }

    

    
    
    
    
    
    
    
}
