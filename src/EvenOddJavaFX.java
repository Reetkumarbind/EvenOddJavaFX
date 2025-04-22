import javafx.application.Application; // Import base JavaFX Application class
import javafx.geometry.Insets; // For spacing around layout containers
import javafx.geometry.Pos; // For aligning contents in layout containers
import javafx.scene.Scene; // Represents the window scene
import javafx.scene.control.*; // Imports all controls (Label, TextField, Button)
import javafx.scene.layout.*; // Imports layout classes like VBox and StackPane
import javafx.stage.Stage; // Represents the primary window (stage) of JavaFX
import javafx.scene.paint.Color; // For coloring UI elements
import javafx.scene.effect.DropShadow; // For adding drop shadow effects
import javafx.scene.text.Font; // For specifying font style and size
import javafx.scene.text.FontWeight; // For specifying font weight

public class EvenOddJavaFX extends Application { // Main class extending JavaFX Application
    @Override
    public void start(Stage primaryStage) { // Entry point for JavaFX UI setup
        // Prompt label
        Label promptLabel = new Label("Enter an integer:"); // Prompt for user input
        promptLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 26)); // Set modern bold font
        promptLabel.setTextFill(Color.web("#40466e")); // Set prompt text color

        // Input field
        TextField inputField = new TextField(); // Field to enter number
        inputField.setPromptText("Type number here..."); // Grey hint text for input field
        inputField.setFont(Font.font("Segoe UI", 25)); // Set modern font for input
        inputField.setStyle(
            "-fx-background-radius: 8; " +      // Rounded background corners
            "-fx-border-radius: 8; " +          // Rounded border corners
            "-fx-border-color: #b7b7b7; " +     // Light gray border
            "-fx-border-width: 1.2;"            // Slightly thick border
        );

        // Button
        Button checkButton = new Button("Check Even/Odd"); // Button to check input
        checkButton.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 24)); // Set bold font for button
        checkButton.setStyle(
            "-fx-background-radius: 8; " +      // Rounded button corners
            "-fx-background-color: #6e78ff; " + // Blue button background
            "-fx-text-fill: white;" +           // White text color
            "-fx-cursor: hand;"                 // Hand cursor on hover
        );

        // Result label
        Label resultLabel = new Label(); // Label to show result (even, odd, or error)
        resultLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 26)); // Result in bold font
        resultLabel.setTextFill(Color.web("#3a8d47")); // Default result color (green shade)

        // Button action
        checkButton.setOnAction(event -> { // Set what happens when button is clicked
            String input = inputField.getText(); // Get input from text field
            try {
                int num = Integer.parseInt(input.trim()); // Try to parse input as integer
                if (num % 2 == 0) { // Check if number is even
                    resultLabel.setText("Even ✔️"); // Show "Even" message with checkmark
                    resultLabel.setTextFill(Color.web("#307cc4")); // Set result color to blue
                } else { // If number is odd
                    resultLabel.setText("Odd ✔️"); // Show "Odd" message with checkmark
                    resultLabel.setTextFill(Color.web("#f07c45")); // Set result color to orange
                }
            } catch (NumberFormatException e) { // Catch invalid input (non-integer)
                resultLabel.setText("Please enter a valid integer."); // Show error message
                resultLabel.setTextFill(Color.web("#ee4444")); // Set error color to red
            }
        });

        // VBox with spacing and padding, centered
        VBox box = new VBox(14, promptLabel, inputField, checkButton, resultLabel); // Arrange controls vertically with spacing
        box.setAlignment(Pos.CENTER); // Center all elements in VBox
        box.setPadding(new Insets(26, 30, 32, 30)); // Padding inside VBox (top, right, bottom, left)
        box.setStyle(
            "-fx-background-color: white;" +         // Card background white
            "-fx-background-radius: 18;" +           // Card rounded corners (background)
            "-fx-border-radius: 18;" +               // Card rounded corners (border)
            "-fx-border-width: 2;" +                 // Thick colored border
            "-fx-border-color: #6e78ff;"             // Border color blue
        );
        box.setEffect(new DropShadow(10, Color.rgb(110,120,255,0.16))); // Drop shadow below card

        // Root pane to center the card
        StackPane root = new StackPane(box); // Center VBox in window using StackPane
        root.setStyle("-fx-background-color:#f5f6fa;"); // Light background for whole window
        Scene scene = new Scene(root, 370, 260); // Create scene with root and set window size

        primaryStage.setTitle("Modern Even/Odd Checker"); // Set title of window
        primaryStage.setScene(scene); // Set scene to stage
        primaryStage.setResizable(false); // Make the window fixed size
        primaryStage.show(); // Show the window
    }

    public static void main(String[] args) { // Entry point for all Java programs
        launch(args); // Launch the JavaFX application
    }
}