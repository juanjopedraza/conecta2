package es.fp.edu.conecta2.servicios;

import es.fp.edu.conecta2.modelo.user.User;
import es.fp.edu.conecta2.repo.user.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepo repo;

    public void registrar(User t){
        repo.save(t);
    }
}

