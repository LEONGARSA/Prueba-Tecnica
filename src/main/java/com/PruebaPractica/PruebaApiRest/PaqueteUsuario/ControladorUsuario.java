package com.PruebaPractica.PruebaApiRest.PaqueteUsuario;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ControladorUsuario {

   private final ServicioUsuario servicioUsuario;

  /* @PostMapping 
    public void createUsuario(@RequestBody ClaseUsuario usuario){

        servicioUsuario.createUsuario(usuario);

    }*/

    @GetMapping(value = "users")
    public Iterable<ClaseUsuario> buscarUsuario(){
        return servicioUsuario.buscarUsuario();
    }


}
