package web.example.project.service;

import org.springframework.stereotype.Service;
import web.example.project.entity.User;

@Service
public interface UserService {

    User save(User user);

    void delete(Long id);

    User update(User user, Long id);

}
