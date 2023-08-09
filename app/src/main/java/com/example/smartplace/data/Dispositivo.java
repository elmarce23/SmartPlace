package com.example.smartplace.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dispositivo {
    @SerializedName("cv_dispositivo")
    @Expose
    private Integer cvDispositivo;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("estado")
    @Expose
    private Integer estado;
    @SerializedName("ubicacion")
    @Expose
    private String ubicacion;
    @SerializedName("activo")
    @Expose
    private Integer activo;

    public Integer getCvDispositivo() {
        return cvDispositivo;
    }

    public void setCvDispositivo(Integer cvDispositivo) {
        this.cvDispositivo = cvDispositivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Dispositivo{" +
                "cvDispositivo=" + cvDispositivo +
                ", nombre='" + nombre + '\'' +
                ", estado=" + estado +
                ", ubicacion='" + ubicacion + '\'' +
                ", activo=" + activo +
                '}';
    }
}
