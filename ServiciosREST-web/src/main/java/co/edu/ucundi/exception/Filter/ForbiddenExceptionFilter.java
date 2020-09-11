/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.exception.Filter;

import co.edu.ucundi.pojo.ErrorWrraper;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author sago9
 */
@Provider
public class ForbiddenExceptionFilter implements ExceptionMapper<ForbiddenException>{

    @Override
    public Response toResponse(ForbiddenException ex) {
         ErrorWrraper error = new ErrorWrraper(ex.getMessage(), "403", "FORBIDDEN");
        return Response.status(Response.Status.FORBIDDEN).entity(error).build();
    }
    
}
