package com.mintic.seguridadMSQ.Repositorios;

import com.mintic.seguridadMSQ.Modelos.Rol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioRol extends MongoRepository<Rol, String> {
}
