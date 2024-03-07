package ticTacToe.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ticTacToe.domain.TicTacToeGame;

import java.util.ArrayList;

public class MainView extends Application {

    private TicTacToeGame game;

    @Override
    public void start(Stage primaryStage) {
        // initialise game
        game = new TicTacToeGame();

        // create main layout, status bar and game board
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10));

        HBox statusBar = new HBox();
        Label statusText = new Label();
        statusText.setFont(Font.font(40));
        statusText.setText(game.getGameStatusMessage());
        statusBar.getChildren().add(statusText);
        layout.setTop(statusBar);

        GridPane gameBoard = new GridPane();
        gameBoard.setHgap(5);
        gameBoard.setVgap(5);
        layout.setCenter(gameBoard);

        // set up game buttons
        ArrayList<Button> buttons = new ArrayList<>();
        for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
            for (int colIdx = 0; colIdx < 3; colIdx++) {
                Button currentButton = new Button();
                currentButton.setPrefSize(69, 69);
                currentButton.setText(this.game.getCellValue(rowIdx, colIdx));

                gameBoard.add(currentButton, rowIdx, colIdx);
                buttons.add(currentButton);

                final int currentRowIdx = rowIdx;
                final int currentColIdx = colIdx;
                currentButton.setOnAction(event -> {
                    if (this.game.playMove(currentRowIdx, currentColIdx)) {
                        currentButton.setText(this.game.getCellValue(currentRowIdx, currentColIdx));
                        currentButton.setDisable(true);
                    }

                    String latestStatus = this.game.getGameStatusMessage();
                    statusText.setText(latestStatus);
                    if (this.game.isOver()) {
                        for (Button b : buttons) {
                            b.setDisable(true);
                        }
                    }
                });
            }
        }

        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void playMoveAndUpdateView(int rowIdx, int colIdx) {
        game.playMove(rowIdx, colIdx);
    }
}
