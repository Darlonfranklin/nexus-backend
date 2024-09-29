package com.nexus.backend.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import com.nexus.backend.domain.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    @DisplayName("CHECK ID IN DATABASE ✅")
    public void testFindById() {
        try {
            Long expectedId = 1L;
            String sql = "SELECT id FROM tb_client WHERE id = :id";
            Map<String, Object> params = new HashMap<>();
            params.put("id", expectedId);
            Long actualId;
            actualId = namedParameterJdbcTemplate.queryForObject(sql, params, Long.class);
            assertThat(actualId).isEqualTo(expectedId);
            Optional<Client> clientOptional = clientRepository.findById(expectedId);
            assertThat(clientOptional).isPresent();
            assertThat(clientOptional.get().getId()).isEqualTo(expectedId);
            assertThat(clientOptional.get().getPerson().getName()).isEqualTo("John Doe");
        } catch (Exception e) {
            fail("Id not found in the database");
        }
    }

    @Test
    @DisplayName("CHECK CPF IN DATABASE ✅")
    public void testFindByCpf() {
        try {
            String expectedCpf = "987.654.321-00";
            String sql = "SELECT cpf FROM tb_client WHERE cpf = :cpf";
            Map<String, Object> params = new HashMap<>();
            params.put("cpf", expectedCpf);
            String actualCpf = namedParameterJdbcTemplate.queryForObject(sql, params, String.class);
            assertThat(actualCpf).isNotNull();
            Optional<Client> foundClient = clientRepository.findByPersonCpf(expectedCpf);
            assertThat(foundClient).isPresent();
            foundClient.ifPresent(client -> {
                assertThat(client.getPerson().getName()).isEqualTo("John Doe");
            });
        } catch (Exception e) {
            fail("CPF not found in the database");
        }
    }
}

