/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.logica;

import co.edu.ucundi.exception.Validacion;
import co.edu.ucundi.pojo.Profesor;
import co.edu.ucundi.pojo.Respuesta;
import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

/**
 * Clase que contiene los metodos logicos del proyecto.
 * @since ServiciosREST 1.0
 * @version 1.0
 * @author Juan Ricardo Rodriguez Campos
 * @author Santiago Gomez Caicedo
 */
public class LogicaServiceProfesor {

    LogicaFicheros fichero = new LogicaFicheros();
    Gson gson = new Gson();

    /**
     * Metodo que trae y convierte en Objetos Profesor los registros del fichero
     * @return
     */
    public List<Profesor> traerListadeJson() {
        List<Profesor> lista = new ArrayList<>();
        for (String obj : fichero.leeFichero()) {
            if (obj != null) {
                Profesor profesor = gson.fromJson(obj, Profesor.class);
                lista.add(profesor);
            }
        }
        return lista;
    }

    /**
     * Metodo que retorna u profesor basandoce en la cedula
     * @param cedula
     * @return
     * @throws Exception
     */
    public Profesor traerProfesorPorCedula(int cedula) throws NotFoundException {
        List<Profesor> lista = new ArrayList<>();
        Profesor profesor;
        Validacion valid = new Validacion();
        valid.validarCedula(cedula);
        if (valid.validacionExistenciaCedula(cedula)) {
            for (String obj : fichero.leeFichero()) {
                if (obj != null) {
                    profesor = gson.fromJson(obj, Profesor.class);
                    if (profesor.getCedula() == cedula) {
                        return profesor;
                    }
                }
            }
        } else {
            throw new NotFoundException("La cedula ingresada no existe en los registros");
        }
        return null;
    }

    /**
     *Metodo que retorna todos los profesores
     * @return
     */
    public Respuesta traerProfesores() {
        Respuesta respuesta;
        List<Profesor> lista = new ArrayList<>();
        for (String obj : fichero.leeFichero()) {
            if (obj != null) {
                Profesor profesor = gson.fromJson(obj, Profesor.class);
                lista.add(profesor);
            }
        }
        if(!lista.isEmpty()){
            respuesta = new Respuesta(200, "Registros Encontrados",lista);
        }else{
            respuesta = new Respuesta(204, "No hay Registros en el archivo", "No hay Registros en el archivo");
        }
        return respuesta ;
    }

    /**
     * Metodo que trae todos los profesores que contienen la materia ingresada
     * @param NombreMateria
     * @return
     */
    public Respuesta traerProfesorPorMateria(String NombreMateria) {
        Respuesta respuesta;
        List<Profesor> lista = new ArrayList<>();
        for (String obj : fichero.leeFichero()) {
            if (obj != null) {
                Profesor profesor = gson.fromJson(obj, Profesor.class);
                if (profesor.getMaterias().contains(NombreMateria)) {
                    lista.add(profesor);
                }
            }
        }
        if (!lista.isEmpty()) {
            return respuesta = new Respuesta(200, "Solicitud exitosa", lista);
        }
        return respuesta = new Respuesta(404, "No hay registros de la materia ingresada", "No hay registros de la materia ingresada");
    }

    /**
     * Metodo que recibe un objeto Profesor y los registra en el fichero.
     * @param profesor
     * @throws Exception
     */
    public void registrarProfesor(Profesor profesor)throws BadRequestException {
        LogicaFicheros logica = new LogicaFicheros();
        Validacion valid = new Validacion();  
        String json = gson.toJson(profesor);
        if (!valid.validacionExistenciaCedula(profesor.getCedula())) {
            logica.escribeFichero(json);
        } else {
            throw new BadRequestException("La cedula ya se encuentra registrada");
        }
    }

    /**
     * Metodo que recibe un objeto profesor y lo actualiza en el fichero
     * @param profesorE
     * @throws Exception
     */
    public void editarProfesor(Profesor profesorE) throws NotFoundException {
        List<Profesor> lista = new ArrayList<>();
        Validacion valid = new Validacion();
        lista = traerListadeJson();
        if (valid.validacionExistenciaCedula(profesorE.getCedula())) {
            for (Profesor obj : lista) {
                if (obj.getCedula() == profesorE.getCedula()) {
                    obj.setNombre(profesorE.getNombre());
                    obj.setApellido(profesorE.getApellido());
                    obj.setEdad(profesorE.getEdad());
                    obj.setCorreo(profesorE.getCorreo());
                }
            }
            reescribirFichero(lista);
        } else {
            throw new NotFoundException("La cedula no se encuentra registrada");
        }

    }

    /**
     * Metodo que recibe una lista de objetos profesor y actualiza el fichero
     * @param lista
     */
    public void reescribirFichero(List<Profesor> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\JavaLineaDeProfundizacion\\ServiciosREST\\fichero1.txt"));) {
            for (Profesor obj : lista) {
                String json = gson.toJson(obj);
                fichero.escribeFichero(json);
            }
        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        }

    }

    /**
     * Metodo que recibe una cedula y elimina el registro del fichero.
     * @param cedula
     * @throws Exception
     */
    public void eliminarProfesor(int cedula) throws NotFoundException {
        Validacion valid = new Validacion();
        List<Profesor> lista = new ArrayList<>();
        if (valid.validacionExistenciaCedula(cedula)) {
            lista = traerListadeJson();
            List<Profesor> listaCopiada = new ArrayList<>(lista);
            for (Profesor obj : listaCopiada) {
                if (obj.getCedula() == cedula) {
                    lista.remove(listaCopiada.indexOf(obj));
                }
            }
            reescribirFichero(lista);
        } else {
            throw new NotFoundException("La cedula no se encuentra registrada");
        }
    }

}
