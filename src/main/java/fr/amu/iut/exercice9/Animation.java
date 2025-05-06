package fr.amu.iut.exercice9;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        CustomButton customButton = new CustomButton();
        root.setCenter(customButton);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Animation Tour Complet");
        primaryStage.show();

        // Force layout pour récupérer les bonnes dimensions
        customButton.applyCss();
        customButton.layout();

        double W = scene.getWidth();
        double H = scene.getHeight();
        double bw = customButton.getBoundsInParent().getWidth();
        double bh = customButton.getBoundsInParent().getHeight();

        double dx = (W - bw) / 2.0;
        double dy = (H - bh) / 2.0;
        Duration dur = Duration.seconds(1);

        TranslateTransition t1 = new TranslateTransition(dur, customButton);
        t1.setByX(dx);            // centre → droite

        TranslateTransition t2 = new TranslateTransition(dur, customButton);
        t2.setByY(-dy);            // droite → haut-droite

        TranslateTransition t3 = new TranslateTransition(dur, customButton);
        t3.setByX(-(W - bw));      // haut-droite → haut-gauche

        TranslateTransition t4 = new TranslateTransition(dur, customButton);
        t4.setByY(H - bh);        // haut-gauche → bas-gauche

        TranslateTransition t5 = new TranslateTransition(dur, customButton);
        t5.setByX(W - bw);        // bas-gauche → bas-droite

        TranslateTransition t6 = new TranslateTransition(dur, customButton);
        t6.setByY(-dy);            // bas-droite → milieu droit

        TranslateTransition t7 = new TranslateTransition(dur, customButton);
        t7.setByX(-dx);            // milieu droit → centre

        // **Le SEUL SequentialTransition** qui enchaîne tes 7 étapes
        SequentialTransition seq = new SequentialTransition(
                t1, t2, t3, t4, t5, t6, t7
        );
        // 1er cycle = tour complet, 2ᵉ cycle (auto-reverse) = retour
        seq.setAutoReverse(true);
        seq.setCycleCount(2);

        // Au clic, on lance la séquence depuis le début
        customButton.setOnMousePressed(evt -> seq.playFromStart());
    }
}