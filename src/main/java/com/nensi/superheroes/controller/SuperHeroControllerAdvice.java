package com.nensi.superheroes.controller;

import com.nensi.superheroes.controller.errors.ErrorResponse;
import com.nensi.superheroes.exception.NonExistingHeroException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SuperHeroControllerAdvice {

    @Value("${superheroes.api.version}")
    private String currentApiVersion;

    @ExceptionHandler(NonExistingHeroException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleNonExistingHero(NonExistingHeroException ex) {
        final ErrorResponse errorResponse = new ErrorResponse(
                currentApiVersion,
                ex.getErrorCode(),
                "Superhero not found",
                "errors",
                "superhero not found",
                "not found",
                "report url"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
