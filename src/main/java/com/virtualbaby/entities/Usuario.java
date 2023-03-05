package com.virtualbaby.entities;

public class Usuario {
    private String idUsuario;
    private String nombreUsuario;
    private String ap_paterno;
    private String ap_materno;
    private String email;
    private String telefono;
    private String password;
    private String tipo;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.format("""
                Usuario{idUsuario='%s',
                nombreUsuario='%s',
                ap_paterno='%s',
                ap_materno='%s',
                email='%s',
                telefono='%s',
                password='%s',
                tipo='%s'
                }""", idUsuario, nombreUsuario, ap_paterno, ap_materno, email, telefono, password, tipo);
    }
}
