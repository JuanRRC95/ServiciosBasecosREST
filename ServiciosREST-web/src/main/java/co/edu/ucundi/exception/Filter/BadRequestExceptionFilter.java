/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.exception.Filter;

import co.edu.ucundi.pojo.ErrorWrraper;
import java.time.LocalDate;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author sago9
 */
@Provider
public class BadRequestExceptionFilter implements ExceptionMapper<BadRequestException> {

    @Override
    public Response toResponse(BadRequestException ex) {
        ErrorWrraper error = new ErrorWrraper("Petición inválida", "La petición es erronea", ex.getMessage(), ex.getStackTrace(),
                LocalDate.now(), Response.Status.BAD_REQUEST);
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }

}
