package com.nexus.backend.domain;
import com.nexus.backend.domain.dtos.ClientDTO;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Person person;

    @OneToMany(mappedBy = "client")
    private List<SalesOrder> salesOrders = new ArrayList<>();

    public Client() {}

    public Client(Long id, Person person) {
        this.id = id;
        this.person = person;
    }

    public Client(ClientDTO obj) {
        this.id = obj.getId();
        this.person = new Person();
        this.person.setName(obj.getName());
        this.person.setCpf(obj.getCpf());
        this.person.setSex(obj.getSex());
        this.person.setPhone(obj.getPhone());
        this.person.setEmail(obj.getEmail());
        this.person.setCep(obj.getCep());
        this.person.setStreetName(obj.getStreetName());
        this.person.setComplement(obj.getComplement());
        this.person.setNeighborhood(obj.getNeighborhood());
        this.person.setNumber(obj.getNumber());
        this.person.setLocality(obj.getLocality());
        this.person.setUf(obj.getUf());
        this.person.setCountry(obj.getCountry());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
