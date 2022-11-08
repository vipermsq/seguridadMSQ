package com.mintic.seguridadMSQ.Repositorios;

import com.mintic.seguridadMSQ.Modelos.PermisoRoles;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RepositorioPermisoRoles extends MongoRepository <PermisoRoles, String > {

}
