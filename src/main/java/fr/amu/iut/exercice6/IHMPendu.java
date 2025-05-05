package fr.amu.iut.exercice6;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class IHMPendu extends Application {

    private static final int MAX_VIES = 7;
    private int vies;
    private String motADeviner;
    private char[] motAffiche;
    private Label labelVies;
    private Label labelMot;
    private TextField inputLettre;
    private Button btnProposer;
    private Dico dico = new Dico();

    @Override
    public void start(Stage stage) {
        vies = MAX_VIES;
        motADeviner = dico.getMot();
        motAffiche = new char[motADeviner.length()];
        for (int i = 0; i < motAffiche.length; i++) motAffiche[i] = '*';

        // --- UI ---
        labelVies = new Label("Vies restantes : " + vies);
        labelMot  = new Label(new String(motAffiche));
        inputLettre = new TextField();
        inputLettre.setPromptText("Une lettre");
        inputLettre.setMaxWidth(80);

        btnProposer = new Button("Proposer");
        btnProposer.setOnAction(e -> proposerLettre());

        VBox root = new VBox(10, labelVies, labelMot, inputLettre, btnProposer);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(root, 300, 200));
        stage.setTitle("Pendu - phase 1");
        stage.show();
    }

    private void proposerLettre() {
        String txt = inputLettre.getText().toLowerCase();
        if (txt.length() != 1) return;
        char lettre = txt.charAt(0);
        inputLettre.clear();

        ArrayList<Integer> pos = dico.getPositions(lettre, motADeviner);
        if (pos.isEmpty()) {
            vies--;
            labelVies.setText("Vies restantes : " + vies);
        } else {
            for (int i : pos) motAffiche[i] = lettre;
            labelMot.setText(new String(motAffiche));
        }

        // fin de partie ?
        if (vies == 0 || new String(motAffiche).equals(motADeviner)) {
            btnProposer.setDisable(true);
            inputLettre.setDisable(true);
            labelVies.setText(vies == 0 ? "Perdu ! Mot : " + motADeviner
                    : "Gagné ! Mot : " + motADeviner);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}