/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.exception.Filter;

import co.edu.ucundi.pojo.ErrorWrraper;
import java.time.LocalDate;
import javax.ws.rs.NotSupportedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author sago9
 */
@Provider
public class NotSupportedExceptionFilter implements ExceptionMapper<NotSupportedException> {

    @Override
    public Response toResponse(NotSupportedException ex) {
        ErrorWrraper error = new ErrorWrraper("tipo de dato no soportado","El recurso al que desea acceder tiene un tipo de dato erroneo",ex.getMessage(),ex.getStackTrace(),
                    LocalDate.now(), Response.Status.UNSUPPORTED_MEDIA_TYPE);
        return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE).entity(error).build();

    }

}
