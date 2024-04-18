package dk.kea.projektgruppe_3_full_stack_new.Service;

import dk.kea.projektgruppe_3_full_stack_new.Model.Product;
import dk.kea.projektgruppe_3_full_stack_new.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(int id, Product product) {
        product.setId(id);
        productRepository.save(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
