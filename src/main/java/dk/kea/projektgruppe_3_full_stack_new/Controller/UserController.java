package dk.kea.projektgruppe_3_full_stack_new.Controller;

import dk.kea.projektgruppe_3_full_stack_new.Model.User;
import dk.kea.projektgruppe_3_full_stack_new.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/opretbruger")
    public String showCreateUserForm() {
        return "OpretBruger";
    }

    @PostMapping("/opretbruger")
    public String createUser (@ModelAttribute User user) {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "loginside";
    }

    @PostMapping("/login")
    public String login (@ModelAttribute User user) {
        if (userRepository.isValidUser(user.getUsername(), user.getPassword())) {
            return "redirect:/"; // Omdirigér til startsiden efter login
        } else {
            return "redirect:/login?error"; // Omdirigér tilbage til login-siden med en fejlmeddelelse
        }
    }
}
