package dk.kea.projektgruppe_3_full_stack_new.Service;

import dk.kea.projektgruppe_3_full_stack_new.Model.Product;
import dk.kea.projektgruppe_3_full_stack_new.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ProductService {

    private static final Logger LOGGER = Logger.getLogger(ProductService.class.getName());
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
    }

    public void addProduct(Product product, MultipartFile imageFile) {
        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                byte[] imageBytes = imageFile.getBytes();
                product.setImage(imageBytes);
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Failure to save uploaded file", e);
                throw new RuntimeException("Failure to save uploaded file", e);
            }
        }
        productRepository.save(product);
    }

    public void updateProduct(int id, Product product, MultipartFile imageFile) {
        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                byte[] imageBytes = imageFile.getBytes();
                product.setImage(imageBytes);
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Failure to update uploaded file", e);
                throw new RuntimeException("Failure to update uploaded file", e);
            }
        }
        product.setId(id);
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
