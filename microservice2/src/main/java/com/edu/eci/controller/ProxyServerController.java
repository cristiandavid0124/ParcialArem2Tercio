package com.edu.eci.controller;

import com.edu.eci.service.RoundRobinService;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyServerController {

    @Autowired
    private RoundRobinService roundRobinService;

    @GetMapping("/linearsearch")
    public String linearSearch(@RequestParam String list, @RequestParam String value) {
        try {
            JsonObject response = roundRobinService.getConnection(list, value, "/linearsearch");
            return response.toString();
        } catch (Exception e) {
            return "{\"error\":\"" + e.getMessage() + "\"}";
        }
    }

    @GetMapping("/binarysearch")
    public String binarySearch(@RequestParam String list, @RequestParam String value) {
        try {
            JsonObject response = roundRobinService.getConnection(list, value, "/binarysearch");
            return response.toString();
        } catch (Exception e) {
            return "{\"error\":\"" + e.getMessage() + "\"}";
        }
    }
}
