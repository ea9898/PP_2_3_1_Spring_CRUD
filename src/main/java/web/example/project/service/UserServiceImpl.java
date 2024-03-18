package web.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.example.project.entity.User;
import web.example.project.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user, Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            if (user.getName() != null) {
                userOptional.get().setName(user.getName());
            }
            if (user.getLastName() != null) {
                userOptional.get().setLastName(user.getLastName());
            }
            if (user.getEmail() != null) {
                userOptional.get().setEmail(user.getEmail());
            }
            return userRepository.save(userOptional.get());
        }
        return null;
    }
}
