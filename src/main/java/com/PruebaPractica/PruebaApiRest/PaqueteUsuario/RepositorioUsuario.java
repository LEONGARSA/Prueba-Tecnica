package com.PruebaPractica.PruebaApiRest.PaqueteUsuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository <ClaseUsuario, Integer> {

}
