/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Asus
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.edu.ucundi.controller.ProfesorController.class);
        resources.add(co.edu.ucundi.exception.Filter.BadRequestExceptionFilter.class);
        resources.add(co.edu.ucundi.exception.Filter.EntityNotFoundFilter.class);
        resources.add(co.edu.ucundi.exception.Filter.ExceptionFilter.class);
        resources.add(co.edu.ucundi.exception.Filter.ForbiddenExceptionFilter.class);
        resources.add(co.edu.ucundi.exception.Filter.InternalServerErrorExceptionFilter.class);
        resources.add(co.edu.ucundi.exception.Filter.NotAcceptableExceptionFilter.class);
        resources.add(co.edu.ucundi.exception.Filter.NotAllowedExceptionFilter.class);
        resources.add(co.edu.ucundi.exception.Filter.NotAuthorizedExceptionFilter.class);
        resources.add(co.edu.ucundi.exception.Filter.NotFoundExceptionFilter.class);
        resources.add(co.edu.ucundi.exception.Filter.NotSupportedExceptionFilter.class);
        resources.add(co.edu.ucundi.exception.Filter.NullPointerExceptionFilter.class);
        resources.add(co.edu.ucundi.exception.Filter.ServiceUnavailableExceptionFilter.class);
        resources.add(co.edu.ucundi.exception.Filter.ValidationExceptionFilter.class);
        resources.add(co.edu.ucundi.exception.Filter.WebApplicationExceptionFilter.class);
    }
    
}
