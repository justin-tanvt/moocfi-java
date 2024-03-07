package vocabulary;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PracticeApplication extends Application {

    private Dictionary dictionary;

    @Override
    public void init() {
        // 1. initialise the dictionary to be used
        this.dictionary = new Dictionary();
    }

    @Override
    public void start(Stage window) {
        // 2. create subviews
        InputView inputView = new InputView(dictionary);
        PracticeView practiceView = new PracticeView(dictionary);

        // 3. create menu components and add to menu layout
        HBox menuLayout = new HBox();
        Button inputButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");
        menuLayout.getChildren().addAll(inputButton, practiceButton);

        // 4. add components to main layout
        BorderPane mainView = new BorderPane();
        mainView.setTop(menuLayout);
        mainView.setCenter(inputView.getView());

        // 5. style all components
        menuLayout.setSpacing(10);
        menuLayout.setPadding(new Insets(20));
        mainView.setPrefSize(400, 300);

        // 6. map button presses to backend logic
        inputButton.setOnAction(event -> {
            mainView.setCenter(inputView.getView());
        });
        practiceButton.setOnAction(event -> {
            mainView.setCenter(practiceView.getView());
        });

        // 7. create scene from layout and display on stage
        Scene scene = new Scene(mainView);
        window.setScene(scene);
        window.show();
        window.requestFocus();
    }

    public static void main(String[] args) {
        launch(PracticeApplication.class);
    }
}
