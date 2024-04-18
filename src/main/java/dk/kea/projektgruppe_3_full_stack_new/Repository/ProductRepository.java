package dk.kea.projektgruppe_3_full_stack_new.Repository;

import dk.kea.projektgruppe_3_full_stack_new.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    public Optional<Product> findById(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        List<Product> products = jdbcTemplate.query(sql, new Object[]{id}, new ProductRowMapper());
        return products.stream().findFirst();
    }

    public int save(Product product) {
        if (product.getId() == 0) {
            String sql = "INSERT INTO products (product_name, product_link, price) VALUES (?, ?, ?)";
            return jdbcTemplate.update(sql, product.getProductName(), product.getProductLink(), product.getPrice());
        } else {
            String sql = "UPDATE products SET product_name = ?, product_link = ?, price = ? WHERE id = ?";
            return jdbcTemplate.update(sql, product.getProductName(), product.getProductLink(), product.getPrice(), product.getId());
        }
    }

    public int deleteById(int id) {
        String sql = "DELETE FROM products WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public List<Product> loadWishList(int wishListID) {
        String sql = "SELECT * FROM wish WHERE wishlist_id = ? ORDER BY id";
        return jdbcTemplate.query(sql, new Object[]{wishListID}, new ProductRowMapper());
    }

    private static class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductLink(rs.getString("product_link"));
            product.setPrice(rs.getBigDecimal("price"));
            product.setWishlist_id(rs.getInt("wishlist_id"));
            return product;
        }
    }
}
