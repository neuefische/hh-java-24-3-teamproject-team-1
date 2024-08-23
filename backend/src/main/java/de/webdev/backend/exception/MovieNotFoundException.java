package de.webdev.backend.exception;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(String id){
        super("Movie not found with id: " + id);
    }
}