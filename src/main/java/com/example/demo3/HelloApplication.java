package com.example.demo3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tip Calculator");

        // Create a GridPane layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Add Text, TextFields and Labels to the grid
        Text sceneTitle = new Text("Welcome to the Tip Calculator");
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label tableTotalLabel = new Label("Table Total:");
        grid.add(tableTotalLabel, 0, 1);

        TextField tableTotalTextField = new TextField();
        grid.add(tableTotalTextField, 1, 1);

        Label numberOfGuestsLabel = new Label("Number of Guests:");
        grid.add(numberOfGuestsLabel, 0, 2);

        TextField numberOfGuestsTextField = new TextField();
        grid.add(numberOfGuestsTextField, 1, 2);

        Button calculateButton = new Button("Calculate");
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(calculateButton);
        grid.add(hBox, 1, 4);

        // Create a Label for displaying the calculated gratuity
        Label gratuityLabel = new Label("Gratuity:");
        grid.add(gratuityLabel, 0, 6);

        Text gratuityText = new Text();
        grid.add(gratuityText, 1, 6);

        // Calculate button action
        calculateButton.setOnAction(e -> {
            // Get the table total from the TextField
            String tableTotalString = tableTotalTextField.getText();

            // Get the number of guests from the TextField
            String numberOfGuestsString = numberOfGuestsTextField.getText();

            // Perform input validation
            if (tableTotalString == null || tableTotalString.trim().isEmpty()) {
                // Show an error message
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid input");
                alert.setContentText("Please enter a valid table total.");

                alert.showAndWait();
            } else if (numberOfGuestsString == null || numberOfGuestsString.trim().isEmpty()) {
                // Show an error message
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid input");
                alert.setContentText("Please enter a valid number of guests.");

                alert.showAndWait();
            } else {
                // Calculate the gratuity
                double tableTotal = Double.parseDouble(tableTotalString);
                int numberOfGuests = Integer.parseInt(numberOfGuestsString);

                double gratuity = 0.0;

                if (numberOfGuests < 8) {
                    gratuity = tableTotal * 0.1;
                } else if (numberOfGuests >= 8 && numberOfGuests <= 15) {
                    gratuity = tableTotal * 0.15;
                } else if (numberOfGuests > 15) {
                    gratuity = tableTotal * 0.2;
                }

                // Display the gratuity
                gratuityText.setText(Double.toString(gratuity));
            }
        });

        // Set the scene and show the stage
        Scene scene = new Scene(grid, 400, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

