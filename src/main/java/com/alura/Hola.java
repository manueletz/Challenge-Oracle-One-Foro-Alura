package com.alura;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hola {

    @RequestMapping("/")
    public String hello(){
        return "Hola comunidad one = ]";
    }
}
