package com.virtualbaby.entities;

public class Nino {
    private String idNino;
    private String fechaNacimiento;
    private String nombreNino;
    private String ap_paterno;
    private String ap_materno;
    private String idTutor;
    private String grupo;

    public String getIdNino() {
        return idNino;
    }

    public void setIdNino(String idNino) {
        this.idNino = idNino;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreNino() {
        return nombreNino;
    }

    public void setNombreNino(String nombreNino) {
        this.nombreNino = nombreNino;
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

    public String getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(String idTutor) {
        this.idTutor = idTutor;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Nino{" +
                "idNino='" + idNino + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", nombreNino='" + nombreNino + '\'' +
                ", ap_paterno='" + ap_paterno + '\'' +
                ", ap_materno='" + ap_materno + '\'' +
                ", idTutor='" + idTutor + '\'' +
                ", grupo='" + grupo + '\'' +
                '}';
    }
}
