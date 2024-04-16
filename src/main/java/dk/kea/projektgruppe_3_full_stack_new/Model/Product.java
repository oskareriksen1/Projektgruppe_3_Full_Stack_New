package dk.kea.projektgruppe_3_full_stack_new.Model;

import java.math.BigDecimal;

public class Product {
    private Long id;             // Unique identifier for the product
    private String productName;  // Name of the product
    private String productLink;  // URL link to the product
    private BigDecimal price;    // Price of the product
    private byte[] image;        // Byte array to store image data

    // Default constructor
    public Product() {
    }

    // Getters and setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
