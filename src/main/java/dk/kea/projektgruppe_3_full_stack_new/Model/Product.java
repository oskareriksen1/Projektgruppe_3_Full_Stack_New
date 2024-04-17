package dk.kea.projektgruppe_3_full_stack_new.Model;

import java.math.BigDecimal;

public class Product {


    private int wishlist_id;
    private int id;
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

    public int setId (int id) {
        this.id = id;
        return id;
    }

    public int setWishlist_id(int wishlist_id) {
        this.wishlist_id = wishlist_id;
        return wishlist_id;
    }
    public int getWishlist_id() {
        return wishlist_id;
    }

    public String getProductName() {
        return productName;
    }

    public String setProductName(String productName) {
        this.productName = productName;
        return productName;
    }

    public String getProductLink() {
        return productLink;
    }

    public String setProductLink(String productLink) {
        this.productLink = productLink;
        return productLink;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal setPrice(BigDecimal price) {
        this.price = price;
        return price;
    }

    /*public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
        return image;
    } */
}
