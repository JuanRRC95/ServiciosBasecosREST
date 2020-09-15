/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.exception.Filter;


import co.edu.ucundi.pojo.ErrorWrraper;
import java.time.LocalDate;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author ASUS-PC
 */
@Provider
public class WebApplicationExceptionFilter implements ExceptionMapper<WebApplicationException>{

    @Override
    public Response toResponse(WebApplicationException ex) {        
        ErrorWrraper error = new ErrorWrraper("Recurso no encontrado","El recurso al que desea acceder no se encuentra disponible",ex.getMessage(),ex.getStackTrace(),
                    LocalDate.now(), Response.Status.NOT_FOUND);
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
    
} 