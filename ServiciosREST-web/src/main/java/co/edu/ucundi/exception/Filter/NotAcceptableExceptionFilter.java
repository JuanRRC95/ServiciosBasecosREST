/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.exception.Filter;

import co.edu.ucundi.pojo.ErrorWrraper;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author sago9
 */
@Provider
public class NotAcceptableExceptionFilter implements ExceptionMapper<NotAcceptableException> {

    @Override
    public Response toResponse(NotAcceptableException ex) {
        ErrorWrraper error = new ErrorWrraper(ex.getMessage(), "406", "NOT_ACCEPTABLE");
        return Response.status(Response.Status.NOT_ACCEPTABLE).entity(error).build();
    }

}
