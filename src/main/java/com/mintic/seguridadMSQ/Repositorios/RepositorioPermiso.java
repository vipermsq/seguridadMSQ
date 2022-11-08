package com.mintic.seguridadMSQ.Repositorios;

import com.mintic.seguridadMSQ.Modelos.Permiso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioPermiso extends MongoRepository<Permiso, String> {
}
