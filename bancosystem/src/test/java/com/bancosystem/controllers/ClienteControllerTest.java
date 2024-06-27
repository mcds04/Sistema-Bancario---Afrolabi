package com.bancosystem.controllers;

import com.bancosystem.model.Cliente;
import com.bancosystem.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Test
    public void criarClienteTest() throws Exception {
        Cliente cliente = new Cliente();            // detalhes do cliente
        given(clienteService.criarCliente(cliente)).willReturn(cliente);

        ObjectMapper objectMapper = new ObjectMapper();
        String clienteJson = objectMapper.writeValueAsString(cliente);

        mockMvc.perform(post("/api/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(clienteJson))
                .andExpect(status().isCreated());
    }
}
