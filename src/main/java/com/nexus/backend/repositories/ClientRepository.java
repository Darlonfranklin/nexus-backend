package com.nexus.backend.repositories;

import com.nexus.backend.domain.Client;
import com.nexus.backend.domain.dtos.ClientDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByPersonCpf(String cpf);

    Optional<Client> findByPersonEmail(String email);
}
