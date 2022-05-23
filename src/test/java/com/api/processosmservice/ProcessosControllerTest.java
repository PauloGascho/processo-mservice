package com.api.processosmservice;

import com.api.processosmservice.model.Processo;
import com.api.processosmservice.repository.ProcessoRepository;
import com.api.processosmservice.service.ProcessoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProcessosControllerTest {
    static final String BASE_URL = "/processos";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProcessoService processoService;

    @MockBean
    ProcessoRepository processoRepository;

    @Test
    public void getProcessos_200() throws Exception {
        Processo processoForm = new Processo(2000,"descricao do processo","Fulano Ciclano");

        when(processoService.create(processoForm)).thenReturn(processoForm);

        mockMvc.perform(
                get(BASE_URL))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());
    }

    @Test
    public void createProcesso_200() throws Exception {
        Processo processoForm = new Processo(2000,"descricao do processo","Fulano Ciclano");
        String processoJson = objectMapper.writeValueAsString(processoForm);

        when(processoService.create(processoForm)).thenReturn(processoForm);

        mockMvc.perform(post(BASE_URL)
                        .content(processoJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(print());
    }

}
