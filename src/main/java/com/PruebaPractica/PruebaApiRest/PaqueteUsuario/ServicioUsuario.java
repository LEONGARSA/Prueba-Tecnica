package com.PruebaPractica.PruebaApiRest.PaqueteUsuario;

import org.hibernate.mapping.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ServicioUsuario {

    private final RepositorioUsuario usuRepo;

    
    public void createUsuario(ClaseUsuario usua) {
     
        usuRepo.save(usua);
    }

    
  /*  public void borrarUsuarioPorID(ClaseUsuario usua) {
    
        usuRepo.deleteById(usua.getId());
        
    }*/


    public Iterable<ClaseUsuario> buscarUsuario() {

        return usuRepo.findAll();
    }


}
