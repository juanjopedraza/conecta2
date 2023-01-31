package es.fp.edu.conecta2.controladores;

import es.fp.edu.conecta2.repo.user.IUserRepo;
import es.fp.edu.conecta2.servicios.UserService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebControlador {

    @GetMapping ("/")
    public String inicio() {

        return "inicio";
    }

    @RequestMapping("parametros/{a}/{b}/{c}")
    public String parametros( @PathVariable int a,
                              @PathVariable int b,
                              @PathVariable int c,
                              Model model) {
        model.addAttribute("a",a);
        model.addAttribute("b",b);
        model.addAttribute("c",c);
        return "parametros";
    }
    @RequestMapping({"opcionales/{a}/{b}/{c}",
            "opcionales/{a}/{b}",
               "opcionales/{a}",
    "opcionales"})
    public String opcionales(
            @PathVariable (name = "a", required = false) String a,
            @PathVariable (name = "b", required = false) String b,
            @PathVariable (name = "c", required = false) String c,
            Model model) {
        if (StringUtils.isEmpty(a)) {
            a = "0";
        }
        if (StringUtils.isEmpty(b)) {
            b = "0";
        }
        if (StringUtils.isEmpty(c)) {
            c = "0";
        }
        model.addAttribute("a",a);
        model.addAttribute("b",b);
        model.addAttribute("c",c);
        return "opcionales";
    }

    @Autowired
    private UserService servicioUser;
    @GetMapping ("/user")
    public String listarUser(Model modelo){
        modelo.addAttribute("user",servicioUser.listarUser());
        return "usuarios";
    }

}
