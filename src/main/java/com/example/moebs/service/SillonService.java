package com.example.moebs.service;

import com.example.moebs.exception.RecordNotFoundException;
import com.example.moebs.model.Sillon;
import com.example.moebs.repository.SillonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SillonService {

    @Autowired
    SillonRepository repository;

    public List<Sillon> getAllSillones() {
        List<Sillon> result = (List<Sillon>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Sillon>();
        }
    }

    public Sillon getSillonById(Long id) throws RecordNotFoundException
    {
        Optional<Sillon> sillon = repository.findById(id);

        if(sillon.isPresent()) {
            return sillon.get();
        } else {
            throw new RecordNotFoundException("No existe el Sillon");
        }
    }

    public Sillon createSillon(Sillon sillon){
        sillon = repository.save(sillon);
        return sillon;
    }

    public Sillon updateSillon(Long id, Sillon sillon) throws RecordNotFoundException{
        Sillon sillon1 = getSillonById(id);
        sillon1.setId(id);
        sillon1.setTipo(sillon.getTipo());
        sillon1.setActivo(sillon.getActivo());
        sillon1.setId_sala(sillon.getId_sala());
        sillon1 = repository.save(sillon1);
        return sillon1;
    }

    public void deleteSillonById(Long id) throws RecordNotFoundException{
        Optional<Sillon> sillon = repository.findById(id);

        if(sillon.isPresent()){
            repository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException("No existe el Sillon");
        }
    }
}