package vocabulary;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputView {
    private final Dictionary dictionary;

    public InputView(Dictionary dictRef) {
        this.dictionary = dictRef;
    }

    public Parent getView() {
        // create components to be added
        Label wordText = new Label("Word");
        TextField wordField = new TextField();
        Label translationText = new Label("Translation");
        TextField translationField = new TextField();
        Button addTranslationButton = new Button("Add the word pair");

        // add components to main layout
        GridPane inputForm = new GridPane();
        inputForm.add(wordText, 0, 0);
        inputForm.add(wordField, 0, 1);
        inputForm.add(translationText, 0, 2);
        inputForm.add(translationField, 0, 3);
        inputForm.add(addTranslationButton, 0, 4);

        // style main layout
        inputForm.setAlignment(Pos.CENTER);
        inputForm.setVgap(10);
        inputForm.setHgap(10);
        inputForm.setPadding(new Insets(10));

        // map button press to backend logic
        addTranslationButton.setOnAction(event -> {
            this.dictionary.add(wordField.getText(), translationField.getText());

            wordField.clear();
            translationField.clear();
        });

        return inputForm;
    }
}
