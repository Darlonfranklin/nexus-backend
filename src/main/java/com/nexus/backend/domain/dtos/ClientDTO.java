package com.nexus.backend.domain.dtos;

import com.nexus.backend.domain.Client;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

public class ClientDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    protected Long id;
    @NotNull(message = "the NAME field is required")
    protected String name;
    @NotNull(message = "the CPF field is required")
    protected String cpf;
    @NotNull(message = "the PHONE field is required")
    protected String phone;
    @NotNull(message = "the EMAIL field is required")
    protected String email;
    @NotNull(message = "the CEP field is required")
    protected String cep;
    @NotNull(message = "the STREETNAME field is required")
    protected String streetName;
    @NotNull(message = "the COMPLEMENT field is required")
    protected String complement;
    @NotNull(message = "the NEIGHBORHOOD field is required")
    protected String neighborhood;
    @NotNull(message = "the NUMBER field is required")
    protected String number;
    @NotNull(message = "the LOCALITY field is required")
    protected String locality;
    @NotNull(message = "the UF field is required")
    protected String uf;

    public ClientDTO() {}

    public ClientDTO(Client obj) {
        this.id = obj.getId();
        this.name = obj.getPerson().getName();
        this.cpf = obj.getPerson().getCpf();
        this.phone = obj.getPerson().getPhone();
        this.email = obj.getPerson().getEmail();
        this.cep = obj.getPerson().getCep();
        this.streetName = obj.getPerson().getStreetName();
        this.complement = obj.getPerson().getComplement();
        this.neighborhood = obj.getPerson().getNeighborhood();
        this.number = obj.getPerson().getNumber();
        this.locality = obj.getPerson().getLocality();
        this.uf = obj.getPerson().getUf();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
