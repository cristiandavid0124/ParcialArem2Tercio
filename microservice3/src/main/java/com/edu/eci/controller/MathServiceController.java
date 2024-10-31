package com.edu.eci.controller;

import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathServiceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MathServiceController.class);

    @GetMapping("/linearsearch")
    public String linearSearch(@RequestParam String list, @RequestParam String value) {
        String[] inputlist = list.split(",");
        JsonObject response = createJsonResponse("linearSearch", inputlist, value);

        LOGGER.info("Making linear search for inputlist: {}, value: {}", list, value);
        for (int i = 0; i < inputlist.length; i++) {
            if (value.equals(inputlist[i])) {
                response.addProperty("output", String.valueOf(i));
                return response.toString();
            }
        }
        response.addProperty("output", String.valueOf(-1));
        return response.toString();
    }

    private JsonObject createJsonResponse(String operation, String[] inputlist, String value) {
        JsonObject response = new JsonObject();
        response.addProperty("operation", operation);
        response.addProperty("inputlist", String.join(",", inputlist));
        response.addProperty("value", value);
        return response;
    }
}