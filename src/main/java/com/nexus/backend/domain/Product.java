package com.nexus.backend.domain;

import com.nexus.backend.domain.dtos.ProductDTO;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String description;
    private String category;
    private String unitMeasure;
    private double unitPrice;
    private int stockQuantity;

    @OneToMany(mappedBy = "product")
    private List<SalesOrder> salesOrders = new ArrayList<>();

    public Product() {}

    public Product(Long id, String productName, String description, String category, String unitMeasure, double unitPrice, int stockQuantity) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.category = category;
        this.unitMeasure = unitMeasure;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
    }

    public Product(ProductDTO obj) {
        this.id = obj.getId();
        this.productName = obj.getProductName();
        this.description = obj.getDescription();
        this.category = obj.getCategory();
        this.unitMeasure = obj.getUnitMeasure();
        this.unitPrice = obj.getUnitPrice();
        this.stockQuantity = obj.getStockQuantity();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public List<SalesOrder> getSalesOrders() {
        return salesOrders;
    }

    public void setSalesOrders(List<SalesOrder> salesOrders) {
        this.salesOrders = salesOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
