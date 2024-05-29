package com.nexus.backend.domain;

import com.nexus.backend.domain.dtos.SalesOrderDTO;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_sales_order")
public class SalesOrder implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Sales sales;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public SalesOrder(Long id, Sales sales, Client client, Product product) {
        this.id = id;
        this.sales = sales;
        this.client = client;
        this.product = product;
    }

    public SalesOrder(SalesOrderDTO obj) {
        this.id = obj.getId();
        this.client.setId(obj.getId());
        this.product.setId(obj.getId());
        this.sales.setRequestDate(obj.getRequestDate());
        this.sales.setProductQuantity(obj.getProductQuantity());
        this.sales.setTotalValue(obj.getTotalValue());
    }

    public SalesOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SalesOrder that = (SalesOrder) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
