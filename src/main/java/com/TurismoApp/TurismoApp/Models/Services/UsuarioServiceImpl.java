package com.TurismoApp.TurismoApp.Models.Services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TurismoApp.TurismoApp.Models.Dao.RolRepository;
import com.TurismoApp.TurismoApp.Models.Dao.UsuarioRepository;
import com.TurismoApp.TurismoApp.Models.Entity.Usuario;
import com.TurismoApp.TurismoApp.Models.Entity.UsuarioRol;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    @Transactional
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findById(usuario.getRutUsuario()).orElse(new Usuario());

        if(usuarioLocal.getRutUsuario() != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }

        else{

            for(UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }
    @Override
    @Transactional
    public Optional<Usuario> getUsuario(String rutUsuario) {
        return usuarioRepository.findById(rutUsuario);
    }

    @Override
    @Transactional
    public void eliminarUsuario(String rutUsuario) {
        usuarioRepository.deleteById(rutUsuario);
    }

    @Override
    @Transactional
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }


    @Override
    @Transactional
    public Usuario actualizaUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findById(usuario.getRutUsuario()).orElse(new Usuario());

        if(usuarioLocal.getRutUsuario() == null){
            System.out.println("El usuario No existe");
            throw new Exception("El usuario No existe");
        }
        else{

            for(UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }


}
