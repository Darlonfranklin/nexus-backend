package com.nexus.backend.domain.dtos;

import com.nexus.backend.domain.Product;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

public class ProductDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    protected Long id;
    @NotNull(message = "the PRODUCT NAME field is required")
    protected String productName;
    @NotNull(message = "the DESCRIPTION field is required")
    protected String description;
    @NotNull(message = "the CATEGORY field is required")
    protected String category;
    @NotNull(message = "the UNIT MEASURE field is required")
    protected String unitMeasure;
    @NotNull(message = "the UNIT PRICE field is required")
    protected double unitPrice;
    @NotNull(message = "the STOCK QUANTITY field is required")
    protected int stockQuantity;

    public ProductDTO() { }

    public ProductDTO(Product obj) {
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
}
