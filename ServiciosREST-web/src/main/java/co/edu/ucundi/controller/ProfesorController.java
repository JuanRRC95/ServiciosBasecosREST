/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.controller;

/**
 *
 * @author Asus
 */
import co.edu.ucundi.exception.Validacion;
import co.edu.ucundi.logica.LogicaServiceProfesor;
import co.edu.ucundi.pojo.Profesor;
import co.edu.ucundi.pojo.Respuesta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Stateless
@Path("/profesores")
public class ProfesorController {

    //@Path("/dato/{id}")
    @Path("/traerPorCedula/{cedula}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response traerPorCedula(@PathParam("cedula") int cedula) {
        System.out.println("Entre al servicio");
        try {
            Validacion valid = new Validacion();
            System.out.println("Entre al try");
            Respuesta respuesta = valid.validarCedula(cedula);
            return Response.status(Response.Status.fromStatusCode(respuesta.getCodigo())).entity(respuesta.getObjeto()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }

    //@Path("/dato/{id}")
    @Path("/traerPorMateria/{materia}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response traerPorMateria(@PathParam("materia") String materia) {
        System.out.println("Entre al servicio");
        LogicaServiceProfesor logica = new LogicaServiceProfesor();
        Respuesta respuesta = logica.traerProfesorPorMateria(materia);
        return Response.status(Response.Status.fromStatusCode(respuesta.getCodigo())).entity(respuesta.getObjeto()).build();
        //}
        //return Response.status(Response.Status.OK).entity("No se encontro el estudiante").build();

    }

    @Path("/traerProfesores")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response traerProfesores() {
        System.out.println("Entre al servicio");
        LogicaServiceProfesor logica = new LogicaServiceProfesor();
        return Response.status(Response.Status.OK).entity(logica.traerProfesores()).build();
        //}
        //return Response.status(Response.Status.OK).entity("No se encontro el estudiante").build();

    }

    /*
     @Path("/traerMaterias")
     @GET
     @Produces(MediaType.APPLICATION_JSON)
     public Response traerMaterias(){
        
        
     return Response.status(Response.Status.OK).entity(lista).build();
     //}
     //return Response.status(Response.Status.OK).entity("No se encontro el estudiante").build();

        
     }
     */
    @Path("/insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertarProfesor(Profesor profesor) {
        System.out.println("Insercion de Estudiante");
        try {
            Validacion v = new Validacion();
            Respuesta respuesta = v.validarProfesor(profesor);
            return Response.status(Response.Status.fromStatusCode(respuesta.getCodigo())).entity(respuesta).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }
    /*
    
     @Path("/traerPorCodigo")
     @GET
     @Produces(MediaType.APPLICATION_JSON)
     public Response traerMateriaPorCodigo(){
        
        
     return Response.status(Response.Status.OK).entity(lista).build();
     //}
     //return Response.status(Response.Status.OK).entity("No se encontro el estudiante").build();

        
     }
    
    
     @Path("/insertar")
     @POST
     @Produces(MediaType.APPLICATION_JSON)
     @Consumes(MediaType.APPLICATION_JSON)
     public Response insertarEstudiante(Estudiante estudiante) {
     System.out.println("Información estudiante");
     System.out.println(estudiante.getNombre() + " " + estudiante.getApellido() + " " + estudiante.getEdad());
     return Response.status(Response.Status.OK).build();
     }
    
     @Path("/insertar2")
     @POST
     @Produces(MediaType.APPLICATION_JSON)
     @Consumes(MediaType.APPLICATION_JSON)
     public Response insertarEstudiante(List<Estudiante> estudiante) {
     System.out.println("Información estudiante");
        
     return Response.status(Response.Status.OK).build();
     }    
     */

    @Path("/editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(Profesor profesor) {
        System.out.println("----------------------------------------------------");
        System.out.println("Editar de Estudiante");
        System.out.println(profesor.toString());
        try {
            Validacion valid = new Validacion();
            Respuesta respuesta = valid.validarProfesorEditar(profesor);
            //LogicaServiceProfesor logica = new LogicaServiceProfesor();
            //logica.editarProfesor(profesor);
            return Response.status(Response.Status.fromStatusCode(respuesta.getCodigo())).entity(respuesta.getMensaje()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("eliminar/{cedula}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("cedula") int cedula) {
        //Lógica de base de datos
        System.out.println("----------------------------------------------------");
        System.out.println("ELIMINACION de Estudiante");
        //System.out.println(profesor.toString());
        try {
            LogicaServiceProfesor logica = new LogicaServiceProfesor();
            Respuesta respuesta = logica.eliminarProfesor(cedula);
            return Response.status(Response.Status.fromStatusCode(respuesta.getCodigo())).entity(respuesta.getObjeto()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
