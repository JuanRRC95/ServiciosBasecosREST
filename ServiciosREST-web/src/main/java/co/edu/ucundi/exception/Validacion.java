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

/**
 *
 * @author Asus
 */
public class Validacion {

    LogicaServiceProfesor logica = new LogicaServiceProfesor();

    public Respuesta validarProfesor(Profesor profesor) throws Exception {
        Respuesta respuesta;
        if (profesor.getNombre().length() == 0 || profesor.getApellido().length() == 0 || profesor.getCedula() <= 0 || profesor.getEdad() <= 0) {
            respuesta = new Respuesta(400, "Uno o varios atributos se enviaron vacios", profesor);
            return respuesta;
        } else {
            if (profesor.getCedula() < 999999) {
                throw new Exception("La cedula es invalida");
            } else {
                if (profesor.getEdad() < 18) {
                    respuesta = new Respuesta(400, "La edad debe ser mayor a 18 años", profesor);
                    return respuesta;
                } else {
                    logica.registrarProfesor(profesor);
                    respuesta = new Respuesta(200, "Registro exitoso", profesor);
                }
            }
        }
        return respuesta;
    }

    public Respuesta validarProfesorEditar(Profesor profesor) throws Exception {
        Respuesta respuesta;
        if (profesor.getNombre().length() == 0 || profesor.getApellido().length() == 0 || profesor.getCedula() <= 0 || profesor.getEdad() <= 0) {
            respuesta = new Respuesta(400, "Uno o varios atributos se enviaron vacios", profesor);
            return respuesta;
        } else {
            if (profesor.getEdad() < 18) {
                respuesta = new Respuesta(400, "La edad debe ser mayor a 18 años", profesor);
                return respuesta;
            } else {
                if (validacionCedula(profesor.getCedula())) {
                    logica.editarProfesor(profesor);
                    respuesta = new Respuesta(201, "Edicion exitosa", profesor);
                } else {
                    respuesta = new Respuesta(400, "La cedula ingresada no esta resgitrada","La cedula ingresada no esta resgitrada");
                }
            }
        }
        return respuesta;
    }

    public Respuesta validarCedula(int cedula) throws Exception {
        Respuesta respuesta;
        System.out.println(cedula);
        if (cedula < 999999) {
            System.out.println("Exception");
            throw new Exception("Cedula invalida");
        }
        System.out.println("Sali bien al servicio");
        respuesta = new Respuesta(200, "Registro exitoso", logica.traerProfesorPorCedula(cedula).getObjeto());
        return respuesta;
    }

    public boolean validacionCedula(int cedula) {
        LogicaServiceProfesor logica = new LogicaServiceProfesor();

        for (Profesor obj : logica.traerListadeJson()) {
            if (cedula == obj.getCedula()) {
                return true;
            }
        }
        return false;
    }

}
