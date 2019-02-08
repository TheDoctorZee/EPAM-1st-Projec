package com.epam.lowcost.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public Greet greeting(){
        System.out.println("WHOOSH");
        return new Greet(1,"Greet 1");
    }

}
