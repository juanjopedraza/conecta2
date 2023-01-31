package es.fp.edu.conecta2.controladores;

import es.fp.edu.conecta2.repo.user.IUserRepo;
import es.fp.edu.conecta2.servicios.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebControlador {

    @GetMapping ("/")
    public String prueba() {
        return "Esto es una prueba";
    }

    @Autowired
    private UserService servicioUser;
    @GetMapping ("/user")
    public String listarUser(Model modelo){
        modelo.addAttribute("user",servicioUser.listarUser());
        return "usuarios";
    }

}
