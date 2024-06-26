package com.example.crud.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="p_id")
    public int p_id;

    @Column(name = "p_name")
    public String p_name;

    @Column(name = "description")
    public String description;

    @Column(name = "quantity")
    public int quantity;

    public Product() {

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product(String category, String p_name, int quantity, int p_id, String description) {
        this.p_name = p_name;
        this.quantity = quantity;
        this.p_id = p_id;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", p_id=" + p_id +
                ", p_name='" + p_name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
