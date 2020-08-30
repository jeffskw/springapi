package io.github.jeffskw.tests;

import io.github.jeffskw.domain.repository.Adresses;
import io.github.jeffskw.rest.controller.AddressController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AddressController.class)
public class DeleteAddressTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private Adresses adresses;

    @Test

    public void deleteAddressById() throws Exception {


        mvc.perform(MockMvcRequestBuilders
                .delete("http://localhost:8080/api/adresses/1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }


}
