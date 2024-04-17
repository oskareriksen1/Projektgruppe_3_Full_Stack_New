package dk.kea.projektgruppe_3_full_stack_new.Service;

import dk.kea.projektgruppe_3_full_stack_new.Model.User;
import dk.kea.projektgruppe_3_full_stack_new.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public void createUser(User user) {
        userRepository.createUser(user);
    }

    public boolean isValidUser(String username, String password) {
        return userRepository.isValidUser(username, password);
    }
}