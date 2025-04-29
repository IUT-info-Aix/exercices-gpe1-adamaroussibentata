package fr.amu.iut.exercice5;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;
    private static ArrayList<Obstacle> obstacles = new ArrayList<>();
    private Timeline timeline;

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();

        // Position initiale : Pacman en haut gauche, Fantôme en bas droite
        pacman.setLayoutX(600);
        pacman.setLayoutY(440);
        fantome.setLayoutX(0);
        fantome.setLayoutY(0);

        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);

        jeu.getChildren().addAll(pacman, fantome);

        // Création des obstacles
        Obstacle obstacle1 = new Obstacle(200, 200, 100, 20);
        Obstacle obstacle2 = new Obstacle(400, 100, 20, 200);
        obstacles.add(obstacle1);
        obstacles.add(obstacle2);

        jeu.getChildren().addAll(obstacles);

        root.setCenter(jeu);
        scene = new Scene(root);

        deplacer(pacman, fantome);

        primaryStage.setTitle("... Pac Man ...");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Lancement du mode rapide (timer 10 secondes)
        lancerChrono(pacman, fantome);
    }

    private void deplacer(Personnage j1, Personnage j2) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            double oldX = j1.getLayoutX();
            double oldY = j1.getLayoutY();
            double oldX2 = j2.getLayoutX();
            double oldY2 = j2.getLayoutY();

            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    break;
            }

            if (collisionObstacle(j1)) {
                j1.setLayoutX(oldX);
                j1.setLayoutY(oldY);
            }
            if (collisionObstacle(j2)) {
                j2.setLayoutX(oldX2);
                j2.setLayoutY(oldY2);
            }

            if (j1.estEnCollision(j2)) {
                System.out.println("Le fantôme a tué le pacman ! Pacman a perdu ce con !");
                if (timeline != null) timeline.stop();
            }
        });
    }

    private boolean collisionObstacle(Personnage p) {
        for (Obstacle o : obstacles) {
            if (p.getBoundsInParent().intersects(o.getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }

    private void lancerChrono(Personnage pacman, Personnage fantome) {
        timeline = new Timeline(new KeyFrame(Duration.seconds(10), e -> {
            System.out.println("Temps écoulé ! Pacman a gagné !");
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}