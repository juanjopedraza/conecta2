package es.fp.edu.conecta2.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador01 {
    @GetMapping ("/")
    public String prueba() {
        return "Esto es una prueba";
    }

}
