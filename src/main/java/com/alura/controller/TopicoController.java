package com.alura.controller;

import com.alura.modelo.Topico;
import com.alura.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    public TopicoRepository topicoRepository;

    @GetMapping
    public List<Topico> leer(){
        return topicoRepository.findAll();
    }
}
