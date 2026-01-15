package com.example.demo.controllers;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exceptions {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task no encontrada");
    }
}
