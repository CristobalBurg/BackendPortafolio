package com.TurismoApp.TurismoApp.Models.Entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.TurismoApp.TurismoApp.Models.Services.Deserializer.CustomAuthorityDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "TR_USUARIO")
public class Usuario implements UserDetails {

    @Id
    @Column(name = "rut_usuario")
    private String rutUsuario;

    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private boolean enabled = true;
    private String perfil;
    @Column(name = "is_admin")
    private int isAdmin;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "usuario")
    @JsonIgnore
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "id_comuna")
    @JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
    private Comuna comuna;

    public boolean getEnabled() {
        return this.enabled;
    }

    public Usuario(String rutUsuario, String username, String password, String nombre, String apellido, String email, String telefono, boolean enabled, String perfil, int isAdmin, Set<UsuarioRol> usuarioRoles, Comuna comuna) {
        this.rutUsuario = rutUsuario;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.enabled = enabled;
        this.perfil = perfil;
        this.isAdmin = isAdmin;
        this.usuarioRoles = usuarioRoles;
        this.comuna = comuna;
    }

    public int getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Usuario isAdmin(int isAdmin) {
        setIsAdmin(isAdmin);
        return this;
    }



    public Comuna getComuna() {
        return this.comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public Usuario(){

    }

    public Usuario(String rutUsuario, String username, String password, String nombre, String apellido, String email, String telefono, boolean enabled, String perfil) {
        this.rutUsuario = rutUsuario;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.enabled = enabled;
        this.perfil = perfil;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public Usuario(String rutUsuario, String username, String password, String nombre, String apellido, String email, String telefono, boolean enabled, String perfil, Set<UsuarioRol> usuarioRoles, Comuna comuna) {
        this.rutUsuario = rutUsuario;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.enabled = enabled;
        this.perfil = perfil;
        this.usuarioRoles = usuarioRoles;
        this.comuna = comuna;
    }

    public Usuario rutUsuario(String rutUsuario) {
        setRutUsuario(rutUsuario);
        return this;
    }

    public Usuario username(String username) {
        setUsername(username);
        return this;
    }

    public Usuario password(String password) {
        setPassword(password);
        return this;
    }

    public Usuario nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Usuario apellido(String apellido) {
        setApellido(apellido);
        return this;
    }

    public Usuario email(String email) {
        setEmail(email);
        return this;
    }

    public Usuario telefono(String telefono) {
        setTelefono(telefono);
        return this;
    }

    public Usuario enabled(boolean enabled) {
        setEnabled(enabled);
        return this;
    }

    public Usuario perfil(String perfil) {
        setPerfil(perfil);
        return this;
    }

    public Usuario usuarioRoles(Set<UsuarioRol> usuarioRoles) {
        setUsuarioRoles(usuarioRoles);
        return this;
    }

    public Usuario comuna(Comuna comuna) {
        setComuna(comuna);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " rutUsuario='" + getRutUsuario() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            ", email='" + getEmail() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", enabled='" + isEnabled() + "'" +
            ", perfil='" + getPerfil() + "'" +
            ", usuarioRoles='" + getUsuarioRoles() + "'" +
            ", comuna='" + getComuna() + "'" +
            "}";
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    @JsonDeserialize(using = CustomAuthorityDeserializer.class)
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> autoridades = new HashSet<>();
        this.usuarioRoles.forEach(usuarioRol -> {
            autoridades.add(new Authority(usuarioRol.getRol().getRolNombre()));
        });
        return autoridades;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }
}