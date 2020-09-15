/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.exception.Filter;


import co.edu.ucundi.pojo.ErrorWrraper;
import java.time.LocalDate;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author ASUS-PC
 */
@Provider
public class NullPointerExceptionFilter implements ExceptionMapper<NullPointerException>{

    @Override
    public Response toResponse(NullPointerException ex) {        
        ErrorWrraper error = new ErrorWrraper("Error del servidor","Error en el servidor",ex.getMessage(),ex.getStackTrace(),
                    LocalDate.now(), Response.Status.INTERNAL_SERVER_ERROR);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
    }
    
}
