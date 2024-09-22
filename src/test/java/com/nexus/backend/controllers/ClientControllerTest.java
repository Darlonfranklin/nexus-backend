package com.nexus.backend.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexus.backend.domain.Client;
import com.nexus.backend.domain.dtos.ClientDTO;
import com.nexus.backend.services.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {

    @InjectMocks
    private ClientController clientController;

    @Mock
    private ClientService clientService;

    private MockMvc mockMvc;

    private ClientDTO clientDTO;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
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
    public void testCreateClient() throws Exception {
        Client client = new Client(clientDTO);
        when(clientService.create(any(ClientDTO.class))).thenReturn(client);

        MvcResult result = mockMvc.perform(post("/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(clientDTO)))
                .andExpect(status().isCreated())
                .andReturn();
        String responseBody = result.getResponse().getContentAsString();
        assertNotNull(responseBody);
        verify(clientService, times(1)).create(any(ClientDTO.class));
    }
}
