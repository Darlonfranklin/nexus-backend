package com.nexus.backend.repositories;
import static org.assertj.core.api.Assertions.assertThat;
import com.nexus.backend.domain.Client;
import com.nexus.backend.domain.dtos.ClientDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    private ClientDTO clientDTO;

    @BeforeEach
    public void setUp() {
        clientDTO = new ClientDTO();
        clientDTO.setName("John Doe");
        clientDTO.setCpf("123.456.789-00");
        clientDTO.setSex("M");
        clientDTO.setPhone("(11) 98765-4321");
        clientDTO.setEmail("johndoe@example.com");
        clientDTO.setCep("12345-678");
        clientDTO.setStreetName("Main Street");
        clientDTO.setComplement("Apt 101");
        clientDTO.setNeighborhood("Central");
        clientDTO.setNumber("123");
        clientDTO.setLocality("New York");
        clientDTO.setUf("NY");
        clientDTO.setCountry("USA");
    }

    @Test
    public void testSaveClient() {
        Client client = new Client(clientDTO);
        Client savedClient = clientRepository.save(client);
        assertThat(savedClient).isNotNull();
        assertThat(savedClient.getId()).isGreaterThan(0);
        assertThat(savedClient.getPerson().getName()).isEqualTo(clientDTO.getName());
        assertThat(savedClient.getPerson().getCpf()).isEqualTo(clientDTO.getCpf());
    }
}
