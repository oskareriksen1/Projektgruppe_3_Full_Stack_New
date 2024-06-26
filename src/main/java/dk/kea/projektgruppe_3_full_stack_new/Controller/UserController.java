package dk.kea.projektgruppe_3_full_stack_new.Controller;

import dk.kea.projektgruppe_3_full_stack_new.Model.User;
import dk.kea.projektgruppe_3_full_stack_new.Repository.DatabaseManager;
import dk.kea.projektgruppe_3_full_stack_new.Repository.UserRepository;
import dk.kea.projektgruppe_3_full_stack_new.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/opretbruger")
    public String showCreateUserForm() {
        return "OpretBruger";
    }

    @PostMapping("/opretbruger")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "loginside";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        int wishListID = DatabaseManager.authenticateUser(username, password);
        if (wishListID != -1) {
        return "redirect:/oenskelisten?wishListID=" + wishListID;
    } else {
        return "redirect:/loginside";
    }
}

}

