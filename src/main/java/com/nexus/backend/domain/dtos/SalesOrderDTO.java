package com.nexus.backend.domain.dtos;

import com.nexus.backend.domain.SalesOrder;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class SalesOrderDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotNull(message = "the CLIENT field is required")
    private Long client;
    @NotNull(message = "the PRODUCT field is required")
    private Long product;
    @NotNull(message = "the REQUEST DATE field is required")
    private LocalDate requestDate;
    @NotNull(message = "the PRODUCT QUANTITY field is required")
    private double productQuantity;
    @NotNull(message = "the TOTAL VALUE field is required")
    private double totalValue;

    private String clientName;
    private String productName;

    public SalesOrderDTO() {}

    public SalesOrderDTO(SalesOrder obj) {
        this.id = obj.getId();
        this.client = obj.getClient().getId();
        this.product = obj.getProduct().getId();
        this.requestDate = obj.getSales().getRequestDate();
        this.productQuantity = obj.getSales().getProductQuantity();
        this.totalValue = obj.getSales().getTotalValue();
        this.clientName = obj.getClient().getPerson().getName();
        this.productName = obj.getProduct().getProductName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public double getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(double productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
