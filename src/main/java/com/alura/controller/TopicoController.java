package com.alura.controller;

import com.alura.modelo.DatosRegistroTopico;
import com.alura.modelo.Topico;
import com.alura.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /*
    @PostMapping
    public Topico agregar(@RequestBody Topico topico){
        return topicoRepository.save(topico);
    }
    */

    @PostMapping
    public void agregar(@RequestBody DatosRegistroTopico datosRegistroTopico){
        //System.out.println(new Topico(datosRegistroTopico));

        //return topicoRepository.save(new Topico(datosRegistroTopico));
        System.out.println("inicio de agregar en Topico Controller");
        Topico topicoPrueba = new Topico(datosRegistroTopico);
        System.out.println(topicoPrueba);
        System.out.println(topicoPrueba.getTitulo());
        System.out.println(topicoPrueba.getMensaje());
        System.out.println(topicoPrueba.getfechaCreacion());
        System.out.println(topicoPrueba.getStatus());
        topicoRepository.save(topicoPrueba);
        System.out.println("fin de agregar en Topico Controller");

    }
}
