package com.chitas.carderio.controller;

import com.chitas.carderio.model.api.Career;
import com.chitas.carderio.service.JQservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
@RequestMapping
public class MainController {

    private final JQservice JQ;

    @Autowired
    public MainController(JQservice jq) {
        JQ = jq;
    }

    @PostMapping("/page")
    public Career generatePage(@RequestParam String prof){
        return JQ.generatePageJSON(prof);
    }

}
