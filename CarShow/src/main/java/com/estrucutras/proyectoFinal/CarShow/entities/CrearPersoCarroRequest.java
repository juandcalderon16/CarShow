package com.estrucutras.proyectoFinal.CarShow.entities;

public class CrearPersoCarroRequest {


        private String usuario;
        private Long carroId;
        private int precioPerso;

        // Getters y Setters
        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public Long getCarroId() {
            return carroId;
        }

        public void setCarroId(Long carroId) {
            this.carroId = carroId;
        }

        public int getPrecioPerso() {
            return precioPerso;
        }

        public void setPrecioPerso(int precioPerso) {
            this.precioPerso = precioPerso;
        }
    }


