package es.fp.edu.conecta2;

import es.fp.edu.conecta2.modelo.user.User;
import es.fp.edu.conecta2.repo.user.IUserRepo;
import es.fp.edu.conecta2.servicios.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Conecta2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Conecta2Application.class, args);
    }

    @Autowired
    private UserService repositorioUser;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setIdUsuario(1);
        user1.setNombres("Juanjo");
        //repositorioUser.registrar(user1);

    }
}
