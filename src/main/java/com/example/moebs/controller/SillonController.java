package com.example.moebs.controller;

import com.example.moebs.exception.RecordNotFoundException;
import com.example.moebs.model.Sillon;
import com.example.moebs.service.SillonService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/sillones")
public class SillonController {

    @Autowired
    SillonService service;

    @RequestMapping(value= "/status", method = RequestMethod.GET)
    public String checkStatus(){
        return "ok";
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Sillon> getAllSillones(@RequestParam(value = "activo", defaultValue = "true") Boolean activo) {
        if (activo){
            return service.getAllSillonesActivos();
        }
        else{
            return service.getAllSillones();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Sillon createSillon(@RequestBody final Sillon sillon){
        Sillon s = service.createSillon(sillon);
        return s;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSillonById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteSillonById(id);
    }

    @PutMapping(path="/{id}", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Sillon updateSillonById(@RequestBody Sillon sillon, @PathVariable("id") Long id) throws RecordNotFoundException {
        Sillon s = service.updateSillon(id, sillon);
        return s;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Sillon getSillon(@PathVariable("id") Long id) throws RecordNotFoundException {
        return service.getSillonById(id);
    }
}