package com.CSC340.HW2;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class RestApiController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/cards")
    public Object getCards() {
        try {
            //CONSUMING A RESTFUL WEB SERVICE (API)
            String url = "https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

//            {
//                "success": true,
//                    "deck_id": "8lw46a0glula",
//                    "remaining": 52,
//                    "shuffled": true
//            }

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            //Extract relevant info from the response and use it for what you want, in this case build a Fruit object
            Cards cards = new Cards(root.get("deck_id").asText(), root.get("remaining").asDouble(),
                    root.get("shuffled").asBoolean());
            return cards;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE,
                    null, ex);
            return "error in /fruit";
        }
    }
}
