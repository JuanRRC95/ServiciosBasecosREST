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
public class ExceptionFilter implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception ex) {
        ErrorWrraper error = new ErrorWrraper("Error en el servidor", "Hubo un problema en el servidor", ex.getMessage(), ex.getStackTrace(),
                LocalDate.now(), Response.Status.INTERNAL_SERVER_ERROR);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
    }

}
