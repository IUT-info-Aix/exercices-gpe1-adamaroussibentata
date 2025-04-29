package fr.amu.iut.exercice2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.*;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);

        String[][] board = {
                {"O", "X", "X"},
                {"O", "O", "X"},
                {"", "", "X"}
        };

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Label cell = new Label(board[row][col]);
                cell.setPrefSize(80, 80);
                cell.setAlignment(Pos.CENTER);
                cell.setFont(Font.font("Comic Sans MS", 40));

                // Couleurs personnalisées
                if (board[row][col].equals("X")) {
                    cell.setTextFill(Color.LIMEGREEN);
                } else if (board[row][col].equals("O")) {
                    cell.setTextFill(Color.DODGERBLUE);
                }

                cell.setStyle("-fx-border-color: lightgrey; -fx-border-width: 2px;");
                grid.add(cell, col, row);
            }
        }

        Scene scene = new Scene(grid);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}

