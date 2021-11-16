package fr.diginamic.models;


import fr.diginamic.utils.FormatTo;

import javax.persistence.*;

/**
 * The Class Categorie.
 */
@Embeddable
public class Categorie implements Descriptif {

    @Column
    private String nom;

    public Categorie() {
    }

    /**
     * Instantiates a new categorie.
     *
     * @param nom the nom
     */
    public Categorie(String nom) {
        this.nom = FormatTo.nom(nom);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Catégorie " + getNom();
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Categorie))
            return false;
        Categorie objCategorie = (Categorie) obj;
        return objCategorie.getNom().equals(this.getNom());
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
