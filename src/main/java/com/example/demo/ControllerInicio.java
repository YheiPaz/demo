package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller//controlado mvc
@Slf4j //Informacion al logggin
public class ControllerInicio {

    @Value("${index.saludo}")
    private String saludo;

    @GetMapping("/")
    public String Inicio(Model model){
        String mensaje="Hola mundo t";
        Persona persona = new Persona();
        persona.setNombre("Alex");
        persona.setApellido("Paz");
        persona.setEmail("alex@gmail.com");
        persona.setTelefono("123456");

        Persona persona2 = new Persona();
        persona2.setNombre("Alex");
        persona2.setApellido("Paz");
        persona2.setEmail("alex@gmail.com");
        persona2.setTelefono("123456");

        List<Persona>personas=new ArrayList<>();
        personas.add(persona);
        personas.add(persona2);

        //mismo que primero personas
        List<Persona>personas2= Arrays.asList(persona,persona2);

        //model informacion que queremos coapartir con nuestra vista
        log.info("Ejecutando el controladar Spring mvc ");
        model.addAttribute("mensaje",mensaje);
        model.addAttribute("saludo",saludo);
        //model.addAttribute("persona",persona);
        model.addAttribute("personas",personas2);
        return "index";
    }
}
