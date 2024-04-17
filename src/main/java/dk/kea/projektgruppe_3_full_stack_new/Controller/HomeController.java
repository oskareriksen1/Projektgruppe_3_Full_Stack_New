package dk.kea.projektgruppe_3_full_stack_new.Controller;

import dk.kea.projektgruppe_3_full_stack_new.Model.Product;
import dk.kea.projektgruppe_3_full_stack_new.Model.User;
import dk.kea.projektgruppe_3_full_stack_new.Repository.ProductRepository;
import dk.kea.projektgruppe_3_full_stack_new.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class HomeController {
    @Autowired UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/loginside")
    public String loginside () {
        return "loginside";
    }

    @GetMapping ("/opretoenske")
    public String opretoenske () {
        return "opretoenske";
    }


    @GetMapping ("/ønskelisten")
    public String Ønskelisten (Model model) {
        List<Product> productList= productRepository.findAll();
        model.addAttribute("products",productList);
        return "Ønskeliste";
    }

    @GetMapping("/")
    public String seBrugere(Model model) {
        List<User> userList = userRepository.getAllUsers();
        model.addAttribute("users", userList);
        return "usersss";
    }

}
