/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.exception.Filter;

import co.edu.ucundi.pojo.ErrorWrraper;
import javax.ws.rs.ServiceUnavailableException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author sago9
 */
@Provider
public class ServiceUnavailableExceptionFilter implements ExceptionMapper<ServiceUnavailableException> {

    @Override
    public Response toResponse(ServiceUnavailableException ex) {
        ErrorWrraper error = new ErrorWrraper(ex.getMessage(), "503", "SERVICE_UNAVAILABLE");
        return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity(error).build();

    }

}
