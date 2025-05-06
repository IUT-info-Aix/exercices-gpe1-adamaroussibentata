package fr.amu.iut.exercice12;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;

public class CustomButton extends Button {

    private final String couleur;
    private final IntegerProperty nbClics = new SimpleIntegerProperty(0);

    public CustomButton(String texte, String couleur) {
        super(texte);
        this.couleur = couleur;
    }


    public int getNbClics() {
        return nbClics.get();
    }


    public void setNbClics(int value) {
        nbClics.set(value);
    }

    /** Propriété nbClics pour attacher des listeners/
     public IntegerProperty nbClicsProperty() {
     return nbClics;
     }

     /** Couleur (hex) associée à ce bouton */
    public String getCouleur() {
        return couleur;
    }
}