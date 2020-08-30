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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AddressController.class)

public class PostAddressTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private Adresses adresses;

    @Test

    public void createAddressTest() throws Exception {
        Address add = new Address();
        add.setStreetName("rua rio parnaiba");
        add.setNumber(10);
        add.setComplement("casa");
        add.setNeighbourhood("sta gertrudes");
        add.setCity("hortolandia");
        add.setState("sp");
        add.setCountry("brasil");
        add.setZipcode("125452");
        add.setLatitude("52231");
        add.setLongitude("878921");

        mvc.perform(MockMvcRequestBuilders
                .post("/api/adresses")
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
