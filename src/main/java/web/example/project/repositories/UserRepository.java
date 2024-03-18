package web.example.project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.example.project.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
