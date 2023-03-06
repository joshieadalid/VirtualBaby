package com.virtualbaby.entities;

public class Sueno {
    private String idSueno;
    private String horaInicio;
    private String horaFin;
    private String obsSueno;
    private String idReporte;

    public String getIdSueno() {
        return idSueno;
    }

    public void setIdSueno(String idSueno) {
        this.idSueno = idSueno;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getObsSueno() {
        return obsSueno;
    }

    public void setObsSueno(String obsSueno) {
        this.obsSueno = obsSueno;
    }

    public String getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(String idReporte) {
        this.idReporte = idReporte;
    }

    @Override
    public String toString() {
        return "Sueno{" +
                "idSueno='" + idSueno + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", horaFin='" + horaFin + '\'' +
                ", obsSueno='" + obsSueno + '\'' +
                ", idReporte='" + idReporte + '\'' +
                '}';
    }
}
