package fr.amu.iut.exercice8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Chargement du fichier FXML depuis le classpath
        Parent root = FXMLLoader.load(
                getClass().getResource("/exercice8/LoginView.fxml")
        );

        // Création de la scène
        Scene scene = new Scene(root);

        // Titre de la fenêtre
        primaryStage.setTitle("FXML Custom Control");

        // On n’a pas besoin d’ajouter la CSS ici,
        // elle est référencée directement dans le FXML (stylesheets="@Login.css")
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
