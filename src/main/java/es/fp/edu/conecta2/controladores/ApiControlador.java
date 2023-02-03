package es.fp.edu.conecta2.controladores;

import es.fp.edu.conecta2.modelo.admin.Admin;
import es.fp.edu.conecta2.modelo.user.User;
import es.fp.edu.conecta2.servicios.AdminService;
import es.fp.edu.conecta2.servicios.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiControlador {
    @Autowired
    private AdminService adminService;


    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/admin")
    public void registrarAdmin(@RequestBody Admin admin){

        adminService.registrar(admin);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    public User registrarUser(@RequestBody User usuario){
        return this.userService.registrar(usuario);
    }

    @Autowired
    private UserService servicioUser;


    @GetMapping()
    public List<User> obtenerUsuarios(){
        return servicioUser.listarUser();
    }

}
