package com.cs307.sustc.project.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public static String Hello(){
        return "Hello World";
    }
}
