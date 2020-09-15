/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.exception.Filter;

import co.edu.ucundi.pojo.ErrorWrraper;
import java.time.LocalDate;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author sago9
 */
@Provider
public class NotAllowedExceptionFilter implements ExceptionMapper<NotAllowedException> {

    @Override
    public Response toResponse(NotAllowedException ex) {
        ErrorWrraper error = new ErrorWrraper("Metodo no permitido","El metodo que intenta acceder no está permitido",ex.getMessage(),ex.getStackTrace(),
                    LocalDate.now(), Response.Status.METHOD_NOT_ALLOWED);
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(error).build();
    }

}
