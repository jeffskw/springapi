package io.github.jeffskw.tests;

import com.sun.xml.internal.ws.api.pipe.ContentType;
import io.github.jeffskw.domain.entity.Address;
import io.github.jeffskw.domain.repository.Adresses;
import io.github.jeffskw.rest.controller.AddressController;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@WebMvcTest(AddressController.class)
public class GetAddressTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private Adresses adresses;

    @Test

    public void dontGetAddressybyIdA() throws Exception {


        mvc.perform(MockMvcRequestBuilders
                .get("/api/adresses/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());

    }


}
