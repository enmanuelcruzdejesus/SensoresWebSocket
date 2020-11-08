package com.example.notificacionsensores.repo;

import com.example.notificacionsensores.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepo extends JpaRepository<SensorData, Integer> {

}
