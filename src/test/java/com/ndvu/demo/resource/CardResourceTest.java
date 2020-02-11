package com.ndvu.demo.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class CardResourceTest {

    @Autowired
    MockMvc mockMvc;

    private void prepareData() throws Exception {
        List<String> cards = new ArrayList<String>();
        cards.add("{\"description\": \"This is the 1st ticket\", \"status\": \"TODO\"}");
        cards.add("{\"description\": \"This is the 2nd ticket\", \"status\": \"DOING\"}");

        for (String card : cards) {
            this.mockMvc.perform(MockMvcRequestBuilders
                    .post("/card")
                    .content(card)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }
    }

    @Test
    public void getAllCardsReturnListOfCards() throws Exception {
        prepareData();

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/card")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"description\":\"This is the 1st ticket\",\"status\":\"TODO\"}," +
                        "{\"id\":2,\"description\":\"This is the 2nd ticket\",\"status\":\"DOING\"}]"));
    }

    @Test
    public void getCardWithCorrectIdReturnCard() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/card/2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":2,\"description\":\"This is the 2nd ticket\",\"status\":\"DOING\"}"));
    }

    @Test
    public void getCardWithWrongIdReturn404() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/card/100")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void createCardReturnNewCardId() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/card")
                .content("{\"description\": \"This is the 1st ticket\", \"status\": \"TODO\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("3"));
    }

    @Test
    public void createCardWithBadRequestReturnError1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/card")
                .content("{\"description\": \"This is the 1st ticket\", \"status\": \"wrong status\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createCardWithBadRequestReturnError2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/card")
                .content("{\"description\": \"This is the 1st ticket\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void editCardWithCorrectDataReturnOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/card/1")
                .content("{\"id\":1, \"description\": \"This is the 1st ticket with edit desc\", \"status\": \"DONE\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void editCardWithBadDataReturnError() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/card/1")
                .content("{\"id\":1, \"description\": \"\", \"status\": \"DONE\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}