package es.fp.edu.conecta2.controladores;

import es.fp.edu.conecta2.modelo.admin.Admin;
import es.fp.edu.conecta2.modelo.user.User;
import es.fp.edu.conecta2.servicios.AdminService;
import es.fp.edu.conecta2.servicios.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/databases")
public class TestController {
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
    public void registrarUser(@RequestBody User usuario){
        userService.registrar(usuario);
    }

}
