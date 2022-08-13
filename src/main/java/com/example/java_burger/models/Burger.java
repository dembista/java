package com.example.java_burger.models;


import jakarta.persistence.*;

@Entity
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private int prix;
    private String description;
    private TypeEtat typeEtat;

    @Column(nullable=true, length = 64)
    private String image;





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
     * @return prix
     */
    public int getPrix() {
        return this.prix;
    }

    /**
     * set field
     *
     * @param prix
     */
    public void setPrix(int prix) {
        this.prix = prix;
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

    /**
     * get field @Column(length=64, nullable=true)
     *
     * @return  image @Column(length=64, nullable=true)

     */
    @Transient
    public String getImage() {
        if (image == null || id == null) return null;

        return "/images/" + id + "/" + image;


    }

    /**
     * set field @Column(length=64, nullable=true)
     *
     * @param image @Column(length=64, nullable=true)

     */
    public void setImage(String image) {
        this.image = image;
    }
}
