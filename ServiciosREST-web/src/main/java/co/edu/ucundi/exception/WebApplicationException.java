/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.exception;

/**
 *
 * @author sago9
 */
public class WebApplicationException extends RuntimeException {

    public WebApplicationException(String message) {
        super(message);
    }
    
}
