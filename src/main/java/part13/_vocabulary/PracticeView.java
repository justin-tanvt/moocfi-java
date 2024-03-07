package vocabulary;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {
    private final Dictionary dictionary;
    private String testedWord;

    public PracticeView(Dictionary dictRef) {
        this.dictionary = dictRef;
    }

    public Parent getView() {
        // get random word to be tested
        this.testedWord = this.dictionary.getRandomWord();

        // create components to be added
        Label instructionText = new Label(getInstructions());
        TextField answerField = new TextField();
        Button answerButton = new Button("Check");
        Label feedbackText = new Label("");

        // add components to main layout
        GridPane practiceView = new GridPane();
        practiceView.add(instructionText, 0, 0);
        practiceView.add(answerField, 0, 1);
        practiceView.add(answerButton, 0, 2);
        practiceView.add(feedbackText, 0, 3);

        // style main layout
        practiceView.setAlignment(Pos.CENTER);
        practiceView.setHgap(10);
        practiceView.setVgap(10);
        practiceView.setPadding(new Insets(10));

        // map button press to backend logic
        answerButton.setOnAction(event -> {
            // give feedback on current answer
            String answer = answerField.getText();
            String feedbackMessage = getFeedback(this.testedWord, answer);
            feedbackText.setText(feedbackMessage);

            // reset to next question
            answerField.clear();
            this.testedWord = getNextWord(this.testedWord);
            String nextQuestion = getInstructions();
            instructionText.setText(nextQuestion);
        });

        return practiceView;
    }

    private String getInstructions() {
        return "Translate the word '" + this.testedWord + "'";
    }

    private String getFeedback(String word, String translationAnswered) {
        String correctTranslation = this.dictionary.get(word);

        if (translationAnswered.equals(correctTranslation)) {
            return "Correct!";
        } else {
            return "Incorrect! The translation of the word '" + word + "' is '" + correctTranslation + "'";
        }
    }

    private String getNextWord(String currentWord) {
        if (this.dictionary.size() < 2) {
            return this.dictionary.getRandomWord();
        }

        while (true) {
            String word = this.dictionary.getRandomWord();
            if (!word.equals(currentWord)) {
                return word;
            }
        }
    }
}
