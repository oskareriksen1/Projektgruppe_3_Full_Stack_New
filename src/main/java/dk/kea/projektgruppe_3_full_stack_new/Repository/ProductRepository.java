package dk.kea.projektgruppe_3_full_stack_new.Repository;

import dk.kea.projektgruppe_3_full_stack_new.Model.Product;
import dk.kea.projektgruppe_3_full_stack_new.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static dk.kea.projektgruppe_3_full_stack_new.Repository.DatabaseManager.dataSource;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;
    private static DataSource dataSource;
    @Autowired
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Optional<Product> findById(Long id) {
        List<Product> products = jdbcTemplate.query(
                "SELECT * FROM products WHERE id = ?",
                new Object[]{id},
                new ProductRowMapper()
        );
        return products.stream().findFirst();
    }

    public int save(Product product) {
        if (product.getId() == null) {
            return jdbcTemplate.update(
                    "INSERT INTO products (product_name, product_link, price, image) VALUES (?, ?, ?, ?)",
                    product.getProductName(), product.getProductLink(), product.getPrice(), product.getImage()
            );
        } else {
            return jdbcTemplate.update(
                    "UPDATE products SET product_name = ?, product_link = ?, price = ?, image = ? WHERE id = ?",
                    product.getProductName(), product.getProductLink(), product.getPrice(), product.getImage(), product.getId()
            );
        }
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM products WHERE id = ?", id);
    }

    private static class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            //product.setId(rs.getLong("id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductLink(rs.getString("product_link"));
            product.setPrice(rs.getBigDecimal("price"));
            return product;
        }
    }

    public List<Product> loadWishList(int wishListID) {
        List<Product> products = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM wish WHERE wishListID = ? ORDER BY wishID";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, wishListID);

                try (ResultSet resultSet = statement.executeQuery()) {

                    while (resultSet.next()) {
                        Product product = new Product();
                        product.setId(resultSet.getInt("id"));
                        product.setWishlist_id(resultSet.getInt("wishlist_id"));
                        product.setProductName(resultSet.getString("product_name"));
                        product.setPrice(resultSet.getBigDecimal("price"));
                        product.setProductLink(resultSet.getString("product_link"));

                        products.add(product);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
}
