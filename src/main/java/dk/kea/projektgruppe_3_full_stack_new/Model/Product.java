package dk.kea.projektgruppe_3_full_stack_new.Model;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String productName;
    private String productLink;
    private BigDecimal price;
    private byte[] image;

    public Product(String productName, byte[] image, String productLink, BigDecimal price) {
        this.productName = productName;
        this.image = image;
        this.productLink = productLink;
        this.price = price;
    }

    public Product() {
    }

    public Product(Long id, String productName, String productLink, BigDecimal price, byte[] image) {
        this.id = id;
        this.productName = productName;
        this.productLink = productLink;
        this.price = price;
        this.image = image;
    }

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
