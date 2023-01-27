package es.fp.edu.conecta2.repo.user;

import es.fp.edu.conecta2.modelo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
}
