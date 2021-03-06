package co.edu.ucundi.controller;

/**
 * Clase que contiene los metodos serviciios del proyecto.
 * @since ServiciosREST 1.0
 * @version 1.0
 * @author Juan Ricardo Rodriguez Campos
 * @author Santiago Gomez Caicedo
 */

import co.edu.ucundi.logica.LogicaServiceProfesor;
import co.edu.ucundi.pojo.Profesor;
import co.edu.ucundi.pojo.Respuesta;
import javax.ejb.Stateless;
import javax.validation.Valid;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Stateless
@Path("/profesores")
public class ProfesorController {

    /**
     * Servicio GET que retorna los datos de un profesor basandose en el numero de cedula
     * @param cedula
     * @return JSON
     */
    @Path("/traerPorCedula/{cedula}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response traerPorCedula(@PathParam("cedula") int cedula) {
        System.out.println("Entre al servicio");      
        LogicaServiceProfesor logica = new LogicaServiceProfesor();
        Profesor profesor = logica.traerProfesorPorCedula(cedula);
        return Response.status(Response.Status.OK).entity(profesor).build();       
    }

    /**
     * Servicio GET que retorna todos los profesores que contengan la materia ingresada 
     * @param materia
     * @return 
     */
    @Path("/traerPorMateria/{materia}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response traerPorMateria(@PathParam("materia") String materia) {
        LogicaServiceProfesor logica = new LogicaServiceProfesor();
        Respuesta respuesta = logica.traerProfesorPorMateria(materia);
        return Response.status(Response.Status.fromStatusCode(respuesta.getCodigo())).entity(respuesta.getObjeto()).build();
    }

    /**
     * Servicio Get que retorna todos los profesores que hay en los registros
     * @return 
     */
    @Path("/traerProfesores")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response traerProfesores() {
        LogicaServiceProfesor logica = new LogicaServiceProfesor();
        Respuesta respuesta = logica.traerProfesores();
        return Response.status(Response.Status.OK).entity(respuesta.getObjeto()).build();
    }

    /**
    * Servicio POST que que recibe un objeto y lo guarda en el registro
    * @param profesor
    * @return 
    */
    @Path("/insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertarProfesor(@Valid Profesor profesor) {
        System.out.println("Insercion de Estudiante");       
        LogicaServiceProfesor logica = new LogicaServiceProfesor();
        logica.registrarProfesor(profesor);
        return Response.status(Response.Status.CREATED).entity("Registro exitoso").build();
    }
    
    /**
     * Servicio PUT que recibe un objeto y lo actualiza en los registros
     * @param profesor
     * @return 
     */
    @Path("/editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(Profesor profesor) {       
            LogicaServiceProfesor logica = new LogicaServiceProfesor();
            logica.editarProfesor(profesor);
            return Response.status(Response.Status.CREATED).entity("Se actualizo el registro exitosamente").build();       
    }
    
    /**
     * Servicio DELETE que recibe un numero de cedula y elimina el registro que contenga el mismo numero
     * @param cedula
     * @return 
     */
    @Path("eliminar/{cedula}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("cedula") int cedula) {      
            LogicaServiceProfesor logica = new LogicaServiceProfesor();
            logica.eliminarProfesor(cedula);
            return Response.status(Response.Status.NO_CONTENT).entity("Registro eliminado").build();       
    }

}
