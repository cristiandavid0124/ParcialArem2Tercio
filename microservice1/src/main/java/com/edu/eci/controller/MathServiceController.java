package com.edu.eci.controller;

import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathServiceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MathServiceController.class);

    @GetMapping("/binarysearch")
    public String binarySearch(@RequestParam String list, @RequestParam String value) {
        String[] inputlist = list.split(",");
        JsonObject response = createJsonResponse("binarySearch", inputlist, value);

        LOGGER.info("Making binary search for inputlist: {}, value: {}", list, value);
        int result = recursiveBinarySearch(inputlist, value, 0, inputlist.length - 1);
        response.addProperty("output", String.valueOf(result));
        return response.toString();
    }

    private int recursiveBinarySearch(String[] inputlist, String value, int left, int right) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            int comparisonResult = inputlist[mid].compareTo(value);
            
            if (comparisonResult == 0) {
                return mid;
            }
            if (comparisonResult > 0) {
                return recursiveBinarySearch(inputlist, value, left, mid - 1);
            }
            return recursiveBinarySearch(inputlist, value, mid + 1, right);
        }
        return -1;
    }
    

    private JsonObject createJsonResponse(String operation, String[] inputlist, String value) {
        JsonObject response = new JsonObject();
        response.addProperty("operation", operation);
        response.addProperty("inputlist", String.join(",", inputlist));
        response.addProperty("value", value);
        return response;
    }
}