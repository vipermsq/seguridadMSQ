package com.mintic.seguridadMSQ.Repositorios;

import com.mintic.seguridadMSQ.Modelos.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RepositorioUsuario extends MongoRepository<Usuario, String> {
    @Query("{correo: ?0}")
    public Usuario getUSerByEmail(String correo);
}
