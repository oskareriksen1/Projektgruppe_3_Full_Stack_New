package dk.kea.projektgruppe_3_full_stack_new.Controller;

import dk.kea.projektgruppe_3_full_stack_new.Model.Product;
import dk.kea.projektgruppe_3_full_stack_new.Model.User;
import dk.kea.projektgruppe_3_full_stack_new.Repository.ProductRepository;
import dk.kea.projektgruppe_3_full_stack_new.Repository.UserRepository;
import dk.kea.projektgruppe_3_full_stack_new.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/loginside")
    public String loginside() {
        return "loginside";
    }

    @GetMapping("/opretoenske")
    public String opretoenske() {
        return "opretoenske";
    }


    @GetMapping ("/oenskelisten")
    public String Ønskelisten (@RequestParam ("wishListID") int wishListID, Model model) {
        List<Product> products = productRepository.loadWishList(wishListID);
        model.addAttribute("wishListID", wishListID);
        model.addAttribute("products", products);
        return "Ønskeliste";
    }

    @GetMapping("/")
    public String seBrugere(Model model) {
        List<User> userList = userRepository.getAllUsers();
        model.addAttribute("users", userList);
        return "usersss";
    }
}