package com.example.java_burger.models;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("GESTIONNAIRE")
public class Livreur extends User{

    private String immatriculation;

    /**
     * get field
     *
     * @return immatriculation
     */
    public String getImmatriculation() {
        return this.immatriculation;
    }

    /**
     * set field
     *
     * @param immatriculation
     */
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
}
