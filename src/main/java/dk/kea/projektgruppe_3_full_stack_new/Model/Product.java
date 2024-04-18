package dk.kea.projektgruppe_3_full_stack_new.Model;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String productName;
    private String productLink;
    private BigDecimal price;

    // Constructors
    public Product() {}

    public Product(int id, String productName, String productLink, BigDecimal price) {
        this.id = id;
        this.productName = productName;
        this.productLink = productLink;
        this.price = price;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int wishlist_id;

    public int getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(int wishlist_id) {
        this.wishlist_id = wishlist_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
