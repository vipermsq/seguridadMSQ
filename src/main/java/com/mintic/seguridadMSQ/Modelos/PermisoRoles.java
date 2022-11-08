package com.mintic.seguridadMSQ.Modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document

public class PermisoRoles {
    @Id
    private String _id;

    @DBRef
    private Permiso permiso;

    @DBRef
    private Rol rol;

    public PermisoRoles(){}

    public String get_id() {
        return _id;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
