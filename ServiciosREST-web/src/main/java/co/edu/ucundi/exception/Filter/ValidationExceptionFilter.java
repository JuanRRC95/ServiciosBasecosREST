/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.exception.Filter;

import co.edu.ucundi.pojo.ErrorWrraper;
import javax.validation.ValidationException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Asus
 */
@Provider
public class ValidationExceptionFilter implements ExceptionMapper<ValidationException> {

    @Override
    public Response toResponse(ValidationException ex) {
        ErrorWrraper error = new ErrorWrraper("Error de Validacion - El Objeto no cumple con el formato deseado", "400", "BAD_REQUEST");
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();

    }
}