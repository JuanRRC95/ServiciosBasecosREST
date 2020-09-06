/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.exception;

import co.edu.ucundi.logica.LogicaFicheros;
import co.edu.ucundi.logica.LogicaServiceProfesor;
import co.edu.ucundi.pojo.Profesor;
import co.edu.ucundi.pojo.Respuesta;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que contiene los metodos de validacion del programa.
 * @since ServiciosREST 1.0
 * @version 1.0
 * @author Juan Ricardo Rodriguez Campos
 * @author Santiago Gomez Caicedo
 */
public class Validacion {

    LogicaServiceProfesor logica = new LogicaServiceProfesor();

    /**
     * Metodo que valida los atributos del objeto Profesor
     * @param profesor
     * @throws Exception 
     */
    public void validarProfesor(Profesor profesor) throws Exception {
        Respuesta respuesta;
        if (profesor.getNombre().length() == 0 || profesor.getApellido().length() == 0 || profesor.getCedula() <= 0 || profesor.getEdad() <= 0) {
            respuesta = new Respuesta(400, "Uno o varios atributos se enviaron vacios", profesor);
            throw new Exception("Uno o varios atributos se enviaron vacios");
        } else {
            if (profesor.getCedula() < 999999) {
                throw new Exception("La cedula es invalida");
            } else {
                if (profesor.getEdad() < 18) {
                    respuesta = new Respuesta(400, "La edad debe ser mayor a 18 años", profesor);
                    throw new Exception("La edad debe ser mayor o igual a 18 años");
                } else {

                }
            }
        }

    }

    /**
     * Metodo que valida el formato de la cedula
     * @param cedula
     * @throws Exception 
     */
    public void validarCedula(int cedula) throws Exception {
        Respuesta respuesta;
        System.out.println(cedula);
        if (cedula < 999999) {
            System.out.println("Exception");
            throw new Exception("Cedula invalida");
        }
        System.out.println("Sali bien al servicio");
   }

    /**
     * Metodo que valida si la cedula ya existe en los registros
     * @param cedula
     * @return 
     */
    public boolean validacionExistenciaCedula(int cedula) {
        LogicaServiceProfesor logica = new LogicaServiceProfesor();
        for (Profesor obj : logica.traerListadeJson()) {
            if (cedula == obj.getCedula()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que valida el coreo ingresado
     * @param correo
     * @throws Exception 
     */
    public void validarCorreo(String correo)throws Exception {
        String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@"
                + "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
        Pattern pattern = Pattern.compile(emailPattern);
        String email = correo;
        if (email != null) {
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                throw new Exception("El correo no es valido");
            } 
        }
    }

}
