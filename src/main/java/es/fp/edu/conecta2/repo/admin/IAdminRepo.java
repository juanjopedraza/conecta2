package es.fp.edu.conecta2.repo.admin;

import es.fp.edu.conecta2.modelo.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin, Integer> {

}
