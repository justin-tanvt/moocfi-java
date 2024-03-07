package part13._person;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PersonApp extends Application {

    public void start(Stage window) {
        // initialise person warehouse
        InMemoryPersonWarehouse warehouse = new InMemoryPersonWarehouse();

        // create UI components
        Label nameText = new Label("Name: ");
        TextField nameField = new TextField();
        Label socSecNumText = new Label("Social security number: ");
        TextField socSecNumField = new TextField();
        Button saveBtn =  new Button("Add person!");

        // add UI components into a layout
        GridPane form = new GridPane();
        form.add(nameText, 0, 0);
        form.add(nameField, 1, 0);
        form.add(socSecNumText, 0, 1);
        form.add(socSecNumField, 1, 1);
        form.add(saveBtn, 1, 2);

        // style layout
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(10));

        // map button press to backend logic
        saveBtn.setOnAction(event -> warehouse.save(new Person(nameField.getText(), socSecNumField.getText())));

        // create scene from layout and display on stage
        Scene scene = new Scene(form);
        window.setScene(scene);
        window.show();
        window.requestFocus();
    }

    public static void main(String[] args) {
        launch(PersonApp.class);
    }
}
