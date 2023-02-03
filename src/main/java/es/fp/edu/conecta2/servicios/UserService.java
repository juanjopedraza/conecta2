package es.fp.edu.conecta2.servicios;

import es.fp.edu.conecta2.modelo.user.User;
import es.fp.edu.conecta2.repo.user.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepo repo;

    public User registrar(User t){
        repo.save(t);
        return t;
    }

    public List<User> listarUser(){
      return repo.findAll();
    }

}

