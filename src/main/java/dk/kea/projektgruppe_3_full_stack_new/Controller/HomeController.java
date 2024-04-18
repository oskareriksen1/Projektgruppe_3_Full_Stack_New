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
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/opretoenske/{wishlistid}")
    public String opretoenske(@PathVariable("wishlistid") int wishlistid, Model model) {
        model.addAttribute("wishlistid", wishlistid);
        return "opretoenske";
    }

    @GetMapping("/")
    public String forside() {
        return "Forside";
    }

    @GetMapping("/oenskelisten")
    public String Ønskelisten(@RequestParam(name = "wishListID", required = false) Integer wishListID, Model model) {
        if (wishListID == null) {
            return "redirect:/default-page";
        }
        List<Product> products = productRepository.loadWishList(wishListID);
        model.addAttribute("wishListID", wishListID);
        model.addAttribute("products", products);
        return "Ønskeliste";
    }
}