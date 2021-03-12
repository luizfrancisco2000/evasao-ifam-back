/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifam.ss.evasao.Controller;


import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author luizf
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExceptionHandlingController extends RuntimeException {
    public ExceptionHandlingController() {
        super();
    }
    public ExceptionHandlingController(String message, Throwable cause) {
        super(message, cause);
    }
    public ExceptionHandlingController(String message) {
        super(message);
    }
    public ExceptionHandlingController(Throwable cause) {
        super(cause);
    }
}