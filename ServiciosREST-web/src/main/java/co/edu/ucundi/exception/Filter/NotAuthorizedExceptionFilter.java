/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.exception.Filter;

import co.edu.ucundi.pojo.ErrorWrraper;
import java.time.LocalDate;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author sago9
 */
@Provider
public class NotAuthorizedExceptionFilter implements ExceptionMapper<NotAuthorizedException> {

    @Override
    public Response toResponse(NotAuthorizedException ex) {
        ErrorWrraper error = new ErrorWrraper("Acceso no autorizado","No tiene permiso para acceder a esta petición",ex.getMessage(),ex.getStackTrace(),
                    LocalDate.now(), Response.Status.UNAUTHORIZED);
        return Response.status(Response.Status.UNAUTHORIZED).entity(error).build();
    }

}
