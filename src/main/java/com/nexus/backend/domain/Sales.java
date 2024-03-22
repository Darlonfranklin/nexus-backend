package com.nexus.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class Sales {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate requestDate;
    private double productQuantity;
    private double totalValue;

    public Sales() {}

    public Sales(LocalDate requestDate, double productQuantity, double totalValue) {
        this.requestDate = requestDate;
        this.productQuantity = productQuantity;
        this.totalValue = totalValue;
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
}
