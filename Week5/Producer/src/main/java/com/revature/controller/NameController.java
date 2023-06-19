package com.revature.controller;

import com.revature.services.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("names")
public class NameController {

    private final NameService nameService;

    @Autowired
    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping("{name}") //localhost:8080/names/{name}
    public String sendName(@PathVariable("name") String name){
        nameService.sendNameToQueue(name);

        return "Hi, " + name +"!";
    }
}
