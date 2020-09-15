/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.pojo;


import co.edu.ucundi.exception.NotModelFoundException;
import co.edu.ucundi.exception.ObjectRequiredException;
import java.time.LocalDate;
import javax.persistence.RollbackException;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;


/**
 *
 * @author sago9
 */
public class ExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception ex) {
        ErrorWrraper api;
        if(ex instanceof NotModelFoundException){
            api = new ErrorWrraper("Recurso no encontrado","El recurso al que desea acceder no se encuentra disponible",ex.getMessage(),ex.getStackTrace(),
                    LocalDate.now(), Response.Status.NOT_FOUND); 
        }else if(ex instanceof NotFoundException){
            api = new ErrorWrraper("Objeto no encontrado",
                "Objeto no encontrado",ex.getMessage(),ex.getStackTrace(),LocalDate.now(), Response.Status.NOT_FOUND);     
        }else if (ex instanceof BadRequestException){
            api = new ErrorWrraper("Parametros o metodo incorrecto",
                "Parametros o metodo incorrecto",ex.getMessage(),ex.getStackTrace(),LocalDate.now(), Response.Status.BAD_REQUEST);  
        }else if(ex instanceof WebApplicationException){
            api = new ErrorWrraper("error interno",
                "Error interno del aplicativo",ex.getMessage(),ex.getStackTrace(),LocalDate.now(), Response.Status.INTERNAL_SERVER_ERROR);    
        }else if(ex instanceof RollbackException){           
            api = new ErrorWrraper("error en llamado de entity",
                "Error interno en el llamado a un Entity",ex.getMessage(),ex.getStackTrace(),LocalDate.now(), Response.Status.INTERNAL_SERVER_ERROR);        
        }else if(ex instanceof ObjectRequiredException){           
            api = new ErrorWrraper("error en formacion de objeto",
                "Error en formacion de objeto",ex.getMessage(),ex.getStackTrace(),LocalDate.now(), Response.Status.BAD_REQUEST);
        }else {   
            api = new ErrorWrraper("Error en ejecucion",
                "Error de aplicativo",ex.getMessage(),ex.getStackTrace(),LocalDate.now(), Response.Status.INTERNAL_SERVER_ERROR);
        }
        return Response.status(api.getCodigo()).entity(api).build();
    }
    
}
