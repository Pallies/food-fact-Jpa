package fr.diginamic.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 * The Class Element.
 * <p>
 * référence pour 100Gr
 * de quantité d'élément
 * pour un attribut Naturel donné
 */
@Entity
@Table(name = "ELEMENT")
public class Element implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The elements. */
    @ManyToOne
    @JoinColumn(name = "ID_PRODUIT", referencedColumnName = "ID")
    private Set<Attributs> attributs = new ArrayList<>();

    @Transient
    private HashMap<String, Double> elements = new HashMap<String, Double>();


    /**
     * #Constructor.
     *
     * @param attribut Enregistre les attributs dans un HashMap
     *                 sous forme Entry<String,Double>
     */
    public Element(Attributs attribut) {
        elements.put(attribut.getNom(), attribut.getQuantite());
    }

    /**
     * Formattage d'affichage
     * Ex: Elements vit A : 0.0
     *
     * @return the string
     */
    @Override
    public String toString() {
        StringBuilder elementString = new StringBuilder();
        for (Entry<String, Double> el : elements.entrySet()) {
            elementString.append("Elements ")
                    .append(el.getKey()).append(" : ").append(el.getValue()).append("\n");
        }

        return elementString.toString();
    }

}
