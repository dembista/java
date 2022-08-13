package com.example.java_burger.models;


import jakarta.persistence.*;

@Entity
public class Menu {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private TypeEtat typeEtat;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get field
     *
     * @return nom
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * set field
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * get field
     *
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * set field
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get field
     *
     * @return typeEtat
     */
    public TypeEtat getTypeEtat() {
        return this.typeEtat;
    }

    /**
     * set field
     *
     * @param typeEtat
     */
    public void setTypeEtat(TypeEtat typeEtat) {
        this.typeEtat = typeEtat;
    }

}
