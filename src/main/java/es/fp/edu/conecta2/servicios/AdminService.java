package es.fp.edu.conecta2.servicios;

import es.fp.edu.conecta2.modelo.admin.Admin;
import es.fp.edu.conecta2.repo.admin.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private IAdminRepo repo;

    public void registrar(Admin t){
        repo.save(t);
    }
}
