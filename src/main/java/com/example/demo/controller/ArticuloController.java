package com.example.demo.controller;

import com.example.demo.services.ArticuloRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class ArticuloController {

    private final ArticuloRepository articuloRepository;

    public ArticuloController(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<Map> getArticulos(){
        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
        map.put("articulos", articuloRepository.findAll() );
        map.put("succes", "ok");
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }
}
