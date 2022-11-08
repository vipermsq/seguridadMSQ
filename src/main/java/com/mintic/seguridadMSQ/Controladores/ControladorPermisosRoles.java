package com.mintic.seguridadMSQ.Controladores;

import com.mintic.seguridadMSQ.Modelos.Permiso;
import com.mintic.seguridadMSQ.Modelos.PermisoRoles;
import com.mintic.seguridadMSQ.Modelos.Rol;
import com.mintic.seguridadMSQ.Repositorios.RepositorioPermiso;
import com.mintic.seguridadMSQ.Repositorios.RepositorioPermisoRoles;
import com.mintic.seguridadMSQ.Repositorios.RepositorioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/permisos-roles")

public class ControladorPermisosRoles {

    @Autowired
    private RepositorioPermisoRoles miRepositorioPermisosRoles;
    @Autowired
    private RepositorioPermiso miRepositorioPermiso;
    @Autowired
    private RepositorioRol miRepositorioRol;

    @GetMapping("")
    public List<PermisoRoles> index() {
        return this.miRepositorioPermisosRoles.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("rol/{id_rol}/permiso/{id_permiso}")
    public PermisoRoles create(@PathVariable String id_rol, @PathVariable String id_permiso){
        PermisoRoles permisoRoles = new PermisoRoles();
        Rol rol = this.miRepositorioRol.findById(id_rol).orElse(null);
        Permiso permiso = this.miRepositorioPermiso.findById(id_permiso).orElse(null);
        if (rol != null && permiso != null){
            permisoRoles.setRol(rol);
            permisoRoles.setPermiso(permiso);
            return this.miRepositorioPermisosRoles.save(permisoRoles);
        } else {
            return null;
        }
    }

    @PutMapping("{id_permisorol}/rol/{id_rol}/permiso/{id_permiso}")
    public PermisoRoles update(@PathVariable String id_permisorol, @PathVariable String id_rol, @PathVariable String id_permiso){
        PermisoRoles permisoRoles = this.miRepositorioPermisosRoles.findById(id_permisorol).orElse(null);
        Rol rol = this.miRepositorioRol.findById(id_rol).orElse(null);
        Permiso permiso = this.miRepositorioPermiso.findById(id_permiso).orElse(null);
        if (permiso != null && permisoRoles != null && rol != null){
            permisoRoles.setRol(rol);
            permisoRoles.setPermiso(permiso);
            return this.miRepositorioPermisosRoles.save(permisoRoles);
        } else {
            return null;
        }

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteP(@PathVariable String id){
        PermisoRoles permisoRoles = this.miRepositorioPermisosRoles.findById(id).orElse(null);
        if (permisoRoles != null){
            this.miRepositorioPermisosRoles.delete(permisoRoles);
        }
    }

    @GetMapping("{id}")
    public PermisoRoles show (@PathVariable String id){
        PermisoRoles permisoRoles = miRepositorioPermisosRoles.findById(id).orElse(null);
        return permisoRoles;
    }


}
