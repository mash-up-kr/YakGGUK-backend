package com.mashup.yakgguk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class TestController {

    @GetMapping(path = "test")
    public String testApi() {
        return "Success";
    }
}
