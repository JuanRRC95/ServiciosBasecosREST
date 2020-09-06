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

/**
 *
 * @author Asus
 */
public class LogicaServiceProfesor {
    
    LogicaFicheros fichero = new LogicaFicheros();
    Gson gson = new Gson();
    
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
    
    public Respuesta traerProfesorPorCedula(int cedula) {
        Respuesta respuesta;
        List<Profesor> lista = new ArrayList<>();
        for (String obj : fichero.leeFichero()) {
            if (obj != null) {
                Profesor profesor = gson.fromJson(obj, Profesor.class);
                if (profesor.getCedula() == cedula) {
                    respuesta = new Respuesta(200, "Solicitud exitosa", profesor);
                    return respuesta;
                }
            }
        }
        return respuesta = new Respuesta(400, "La cedula no se encuentra en los registros", "La cedula no se encuentra en los registros");
    }
    
    public List<Profesor> traerProfesores() {
        List<Profesor> lista = new ArrayList<>();
        for (String obj : fichero.leeFichero()) {
            if (obj != null) {
                Profesor profesor = gson.fromJson(obj, Profesor.class);
                lista.add(profesor);
            }
        }
        return lista;
    }
    
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
            return respuesta = new Respuesta(400, "Solicitud exitosa", lista);
        }
        return respuesta = new Respuesta(400, "", "No hay registros de la materia ingresada");
    }
    
    public void registrarProfesor(Profesor profesor) {
        LogicaFicheros logica = new LogicaFicheros();
        String json = gson.toJson(profesor);
        logica.escribeFichero(json);
        
    }
    
    public Respuesta editarProfesor(Profesor profesorE) {
        List<Profesor> lista = new ArrayList<>();
        Respuesta respuesta;
        int cont = 0;
        for (String obj : fichero.leeFichero()) {
            if (obj != null) {
                Profesor profesor = gson.fromJson(obj, Profesor.class);
                lista.add(profesor);
            }
        }
        try {
            for (Profesor obj : lista) {
                if (obj.getCedula() == profesorE.getCedula()) {
                    obj.setNombre(profesorE.getNombre());
                    obj.setApellido(profesorE.getApellido());
                    obj.setEdad(profesorE.getEdad());
                    obj.setMaterias(profesorE.getMaterias());
                } else {
                    cont++;
                }
            }
            if (cont == lista.size()) {
                return respuesta = new Respuesta(400, "La cedula ingresada no se encuentra registrada", "La cedula ingresada no se encuentra registrada");
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        reescribirFichero(lista);
        return respuesta = new Respuesta(201, "El registro se edito con exito", "El registro se edito con exito");
    }
    
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
    
    public Respuesta eliminarProfesor(int cedula) {
        Respuesta respuesta;
        Validacion valid = new Validacion();
        List<Profesor> lista = new ArrayList<>();       
            if (valid.validacionCedula(cedula)) {
                lista = traerListadeJson();
                List<Profesor> listaCopiada = new ArrayList<>(lista);
                for (Profesor obj : listaCopiada) {
                    if (obj.getCedula() == cedula) 
                        lista.remove(listaCopiada.indexOf(obj));                   
                }
                reescribirFichero(lista);
                return respuesta = new Respuesta(201, "", "El registro se elinimo satisfactoriamente");
            }              
        return respuesta = new Respuesta(400, "", "La cedula no esta registrada");
    }
    
}
