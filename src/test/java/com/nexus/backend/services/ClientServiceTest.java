package com.nexus.backend.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.nexus.backend.domain.Client;
import com.nexus.backend.domain.dtos.ClientDTO;
import com.nexus.backend.repositories.ClientRepository;
import com.nexus.backend.services.exceptions.DataIntegrityViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @InjectMocks
    ClientService service;

    @Mock
    ClientRepository repository;

    Client client;
    ClientDTO clientDTO;

    @BeforeEach
    public void setUp() {
        clientDTO = new ClientDTO();
        clientDTO.setId(1L);
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
        client = new Client(clientDTO);
    }

    @Test
    public void testSaveClient() {
        when(repository.save(any(Client.class))).thenReturn(client);
        Client savedClient = service.create(clientDTO);
        assertNotNull(savedClient);
        assertEquals(client.getPerson().getName(), savedClient.getPerson().getName());
        assertEquals(client.getPerson().getCpf(), savedClient.getPerson().getCpf());
        assertEquals(client.getPerson().getEmail(), savedClient.getPerson().getEmail());
        verify(repository, times(1)).save(any(Client.class));
    }

    @Test
    public void testValidForCpfAndEmail_CpfExists() {
        Client existingClient = new Client();
        existingClient.setId(2L);
        when(repository.findByPersonCpf(clientDTO.getCpf())).thenReturn(Optional.of(existingClient));
        DataIntegrityViolationException exception = assertThrows(DataIntegrityViolationException.class, () -> {
            service.validForCpfAndEmail(clientDTO);
        });
        assertEquals("CPF already exists", exception.getMessage());
    }

    @Test
    public void testValidForCpfAndEmail_EmailExists() {
        Client existingClient = new Client();
        existingClient.setId(2L);
        when(repository.findByPersonEmail(clientDTO.getEmail())).thenReturn(Optional.of(existingClient));
        DataIntegrityViolationException exception = assertThrows(DataIntegrityViolationException.class, () -> {
            service.validForCpfAndEmail(clientDTO);
        });
        assertEquals("E-MAIL already exists", exception.getMessage());
    }

    @Test
    public void testValidForCpfAndEmail_NoConflict() {
        when(repository.findByPersonCpf(clientDTO.getCpf())).thenReturn(Optional.empty());
        when(repository.findByPersonEmail(clientDTO.getEmail())).thenReturn(Optional.empty());
        assertDoesNotThrow(() -> service.validForCpfAndEmail(clientDTO));
    }
}
