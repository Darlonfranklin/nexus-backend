package com.nexus.backend.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Person {

    private String name;
    private String cpf;
    private String sex;
    private String phone;
    private String email;
    private String cep;
    private String streetName;
    private String complement;
    private String neighborhood;
    private String number;
    private String locality;
    private String uf;

    private String country;

    public Person() {}

    public Person(String name, String cpf, String sex, String phone, String email, String cep, String streetName, String complement, String neighborhood, String number, String locality, String uf, String country) {
        this.name = name;
        this.cpf = cpf;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.cep = cep;
        this.streetName = streetName;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.number = number;
        this.locality = locality;
        this.uf = uf;
        this.country = country;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
