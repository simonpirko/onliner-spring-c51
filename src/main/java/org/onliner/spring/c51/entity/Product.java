package org.onliner.spring.c51.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Product {

    private String name;
    private int price;
    private String seller;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", seller='" + seller + '\'' +
                '}';
    }

}
