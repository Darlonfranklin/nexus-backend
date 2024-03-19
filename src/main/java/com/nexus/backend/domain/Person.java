package com.nexus.backend.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Person {

    private String name;
    private String cpf;
    private String phone;
    private String email;
    private String cep;
    private String streetName;
    private String complement;
    private String neighborhood;
    private String locality;
    private String uf;

    public Person() {}

    public Person(String name, String cpf, String phone, String email, String cep, String streetName, String complement, String neighborhood, String locality, String uf) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.email = email;
        this.cep = cep;
        this.streetName = streetName;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.locality = locality;
        this.uf = uf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
