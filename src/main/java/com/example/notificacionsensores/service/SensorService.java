package com.example.notificacionsensores.service;

import com.example.notificacionsensores.model.SensorData;
import com.example.notificacionsensores.repo.SensorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {
    @Autowired
    private SensorRepo repo;

    public List<SensorData> getall(){
        return  repo.findAll();
    }

    public Optional<SensorData> getById(int id){
        return repo.findById(id);
    }

    public SensorData save(SensorData sensor){
        return repo.save(sensor);
    }

    public void delete(int id){
        this.repo.deleteById(id);
    }
}
