package com.estrucutras.proyectoFinal.CarShow.entities;

public class CrearFacturaRequest {

    private Long personalizacionId;
    private Long estadoId;

    // Getters y Setters
    public Long getPersonalizacionId() {
        return personalizacionId;
    }

    public void setPersonalizacionId(Long personalizacionId) {
        this.personalizacionId = personalizacionId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }
}

