package io.github.jeffskw.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.jeffskw.domain.entity.Address;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AddressController.class)

public class putAddressTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private Adresses adresses;

    @Test

    public void putAddressTest() throws Exception {
        Address add = new Address();
        add.setStreetName("rua rio parnaiba2");
        add.setNumber(11);
        add.setComplement("casa2");
        add.setNeighbourhood("sta gertrudes2");
        add.setCity("hortolandia2");
        add.setState("sp");
        add.setCountry("brasil2");
        add.setZipcode("1254522");
        add.setLatitude("522312");
        add.setLongitude("8789212");

        mvc.perform(MockMvcRequestBuilders
                .put("localhost:8080/api/adresses/{id}", 1)
                .content(asJsonString(add))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
