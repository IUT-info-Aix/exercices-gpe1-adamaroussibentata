package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginControl {

    @FXML
    private TextField userIdField;

    @FXML
    private PasswordField passwordField;

    /**
     * Appelé automatiquement après le chargement du FXML.
     * Vous pouvez l’utiliser pour initialiser des choses si besoin.
     */
    @FXML
    private void initialize() {
        // rien de particulier à faire ici
    }

    /**
     * Handler du bouton "Ok".
     * Affiche dans la console : userId + une suite d'étoiles de la longueur du mot de passe.
     */
    @FXML
    private void handleOk() {
        String user    = userIdField.getText();
        String pwd     = passwordField.getText();
        String stars   = "*".repeat(pwd.length());
        System.out.println(user + " " + stars);
    }

    /**
     * Handler du bouton "Cancel".
     * Vide les deux champs de saisie.
     */
    @FXML
    private void handleCancel() {
        userIdField.clear();
        passwordField.clear();
    }
}