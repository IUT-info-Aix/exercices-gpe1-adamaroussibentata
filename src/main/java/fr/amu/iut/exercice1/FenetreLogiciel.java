package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Menu du haut
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuHelp = new Menu("Help");
        menuBar.getMenus().addAll(menuFile, menuEdit, menuHelp);

        // Colonne de gauche avec les boutons
        VBox leftButtons = new VBox(10);
        leftButtons.setPadding(new Insets(30, 10, 10, 10)); // espace pour descendre un peu
        leftButtons.setAlignment(Pos.CENTER_LEFT);
        leftButtons.getChildren().add(new Label("Boutons :"));
        leftButtons.getChildren().addAll(
                new Button("Bouton 1"),
                new Button("Bouton 2"),
                new Button("Bouton 3")
        );

        // Séparateur vertical à droite des boutons
        Separator verticalSeparator = new Separator();
        verticalSeparator.setOrientation(javafx.geometry.Orientation.VERTICAL);

        // Formulaire centré
        GridPane formPane = new GridPane();
        formPane.setAlignment(Pos.CENTER_RIGHT);
        formPane.setHgap(10);
        formPane.setVgap(10);

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");
        HBox formButtons = new HBox(10, submitButton, cancelButton);
        formButtons.setAlignment(Pos.CENTER_RIGHT);

        formPane.add(nameLabel, 0, 0);
        formPane.add(nameField, 1, 0);
        formPane.add(emailLabel, 0, 1);
        formPane.add(emailField, 1, 1);
        formPane.add(passwordLabel, 0, 2);
        formPane.add(passwordField, 1, 2);
        formPane.add(formButtons, 1, 3);

        // Conteneur horizontal central
        HBox centerContent = new HBox(30);
        centerContent.setPadding(new Insets(20, 20, 20, 20));
        centerContent.setAlignment(Pos.TOP_LEFT);
        centerContent.getChildren().addAll(leftButtons, verticalSeparator, formPane);

        // Séparateur horizontal au-dessus du label
        Separator horizontalSeparator = new Separator();

        // Label du bas de page
        Label footer = new Label("Ceci est un label de bas de page");
        HBox footerBox = new HBox(footer);
        footerBox.setAlignment(Pos.BOTTOM_CENTER);
        footerBox.setPadding(new Insets(10));

        // Conteneur principal
        VBox mainContainer = new VBox();
        mainContainer.getChildren().addAll(menuBar, centerContent, horizontalSeparator, footerBox);
        VBox.setVgrow(centerContent, Priority.ALWAYS);

        // Création de la scène
        Scene scene = new Scene(mainContainer, 600, 400);
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

