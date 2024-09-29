package com.nexus.backend.services;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.nexus.backend.connection.TestDatabaseInitializer;
import com.nexus.backend.domain.Client;
import com.nexus.backend.domain.dtos.ClientDTO;
import com.nexus.backend.repositories.ClientRepository;
import com.nexus.backend.services.exceptions.DataIntegrityViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Autowired
    private ClientService service;

    @Test
    @Sql(scripts = "classpath:sql/dataClient.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void testSaveClient() {
        Long clientId = 1L;
        Optional<Client> foundClientOptional = Optional.ofNullable(service.findById(clientId));
        assertTrue(foundClientOptional.isPresent(), "O cliente deve estar presente");
        Client savedClient = foundClientOptional.get();
        assertEquals("John Doe", savedClient.getPerson().getName(), "O nome do cliente deve ser 'John Doe'");
        assertEquals("98765432100", savedClient.getPerson().getCpf().replaceAll("\\D", ""), "O CPF do cliente deve ser '98765432100'");
        assertEquals("johndoe@example.com", savedClient.getPerson().getEmail(), "O email do cliente deve ser 'johndoe@example.com'");
        verify(service, times(1)).create(any(ClientDTO.class));
    }


//    @Test
//    public void testValidForCpfAndEmail_CpfExists() {
//        Client existingClient = new Client();
//        existingClient.setId(2L);
//        when(repository.findByPersonCpf(clientDTO.getCpf())).thenReturn(Optional.of(existingClient));
//        DataIntegrityViolationException exception = assertThrows(DataIntegrityViolationException.class, () -> {
//            service.validForCpfAndEmail(clientDTO);
//        });
//        assertEquals("CPF already exists", exception.getMessage());
//    }

//    @Test
//    public void testValidForCpfAndEmail_EmailExists() {
//        Client existingClient = new Client();
//        existingClient.setId(2L);
//        when(service.findByPersonEmail(clientDTO.getEmail())).thenReturn(Optional.of(existingClient));
//        DataIntegrityViolationException exception = assertThrows(DataIntegrityViolationException.class, () -> {
//            service.validForCpfAndEmail(clientDTO);
//        });
//        assertEquals("E-MAIL already exists", exception.getMessage());
//    }

//    @Test
//    public void testValidForCpfAndEmail_NoConflict() {
//        when(service.findByPersonCpf(clientDTO.getCpf())).thenReturn(Optional.empty());
//        when(service.findByPersonEmail(clientDTO.getEmail())).thenReturn(Optional.empty());
//        assertDoesNotThrow(() -> service.validForCpfAndEmail(clientDTO));
//    }
}
