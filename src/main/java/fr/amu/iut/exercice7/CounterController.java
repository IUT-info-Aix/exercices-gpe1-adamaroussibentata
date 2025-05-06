package fr.amu.iut.exercice7;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class CounterController {

    @FXML
    private Label counterLabel;  // lié au <Label fx:id="counterLabel">

    private int counter = 0;     // valeur du compteur

    /**
     * Appelé juste après le chargement du FXML : initialise l'affichage.
     */
    @FXML
    private void initialize() {
        counterLabel.setText(String.valueOf(counter));
    }

    /**
     * Incrémente le compteur et met à jour le label.
     * Lien FXML : onAction="#increment"
     */
    @FXML
    private void increment(ActionEvent event) {
        counter++;
        counterLabel.setText(String.valueOf(counter));
    }

    /**
     * Décrémente le compteur et met à jour le label.
     * Lien FXML : onAction="#decrement"
     */
    @FXML
    private void decrement(ActionEvent event) {
        counter--;
        counterLabel.setText(String.valueOf(counter));
    }
}
