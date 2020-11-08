package com.example.notificacionsensores.controller;

import com.example.notificacionsensores.model.SensorData;
import com.example.notificacionsensores.service.SensorService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SensorController {

    @Autowired
    SensorService service;


    @MessageMapping("/notificacion_sensores")
    @SendTo("/topic/sensordata")
    public SensorData register(@Payload SensorData sensorData) {
        if(sensorData!=null)
             return service.save(sensorData);
        else
            return null;
    }

    @GetMapping("/sensorcapture")
    public String sensorcapture(){
        return "sensorcapture";
    }

    @GetMapping("/sensorchart")
    public String sensorchart(){
        return "sensorchart";
    }

    @RequestMapping("/sensordata/getall")
    @ResponseBody
    public String getAll(){
        List<SensorData> data = this.service.getall();
        JsonArray temperatures1 = new JsonArray();
        JsonArray humidities1 = new JsonArray();
        JsonArray temperatures2 = new JsonArray();
        JsonArray humidities2 = new JsonArray();


        JsonObject json = new JsonObject();
        data.forEach(i ->{
            if(i.getDeviceid() == 1){
                temperatures1.add(i.getTemperature());
                humidities1.add(i.getHumidity());
            }else{
                temperatures2.add(i.getTemperature());
                humidities2.add(i.getHumidity());
            }

        });
        json.add("temperatures1",temperatures1);
        json.add("humidities1",humidities1);
        json.add("temperatures2",temperatures1);
        json.add("humidities2",humidities1);
          return json.toString();
    }




}
