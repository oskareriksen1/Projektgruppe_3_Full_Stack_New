package dk.kea.projektgruppe_3_full_stack_new.Controller;

import dk.kea.projektgruppe_3_full_stack_new.Model.Product;
import dk.kea.projektgruppe_3_full_stack_new.Service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ModelAndView createProduct(
            @RequestParam("produktnavn") String productName,
            @RequestParam("productLink") String productLink,
            @RequestParam("pris") BigDecimal price,
            @RequestParam("wishlistid") int wishListId) {

        Product product = new Product();
        product.setProductName(productName);
        product.setProductLink(productLink);
        product.setPrice(price);
        product.setWishlist_id(wishListId);

        productService.addProduct(product);

        return new ModelAndView("redirect:/oenskelisten");
    }
}
