package dk.kea.projektgruppe_3_full_stack_new.Controller;

import dk.kea.projektgruppe_3_full_stack_new.Model.User;
import dk.kea.projektgruppe_3_full_stack_new.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class HomeController {
    @Autowired UserRepository userRepository;

@GetMapping("/")
public String hej() {
    return "usersss";
}

    @GetMapping("/loginside")
    public String loginside () {
        return "loginside";
    }

    @GetMapping ("/opretoenske")
    public String opretoenske () {
        return "opretoenske";
    }


    @GetMapping ("/ønskelisten")
    public String Ønskelisten () {
        return "Ønskeliste";
    }

    @GetMapping("/brugere")
    public String seBrugere(Model model) {
        List<User> userList = userRepository.getAllUsers();
        model.addAttribute("users", userList);
        return "usersss";
    }
}
