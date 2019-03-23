import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BinaryTreeTranslatorView {

    /**
     * TextAreas for show the results
     */
    private TextArea input;
    private TextArea result;
    private FileChooser fileChooser;

    private boolean isDictionaryLoaded, isTextToTranslateLoaded = false;


    public void show(Stage stage) {
        input = new TextArea("");
        result = new TextArea("...");
        fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );

        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        fileChooser.setInitialDirectory(new File(currentPath));

        BorderPane border = new BorderPane();
        HBox hbox = addHBox(stage);
        border.setTop(hbox);
        border.setLeft(addVBox());

        Scene scene = new Scene(border, 800, 600);
        stage.setTitle("Translator");
        //scene.getStylesheets().add(Calculadora.class.getResource("estilo.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }

    /**
     * To return a HBox with two buttons for read file and clear TextArea
     *
     * @param stage Stage of JavaFX where we're gonna render the UI
     * @return a filled HBox to add to the UI
     */
    public HBox addHBox(Stage stage) {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(6);
        hbox.setStyle("-fx-background-color: #455a64;");

        Button buttonLoadTextToTranslate = new Button("Load text to translate...");
        buttonLoadTextToTranslate.setPrefSize(200, 20);
        buttonLoadTextToTranslate.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                ArrayList<String> myLines = readFile(selectedFile);
                for (String line : myLines) {
                    input.appendText("\n" + line);
                }
                isTextToTranslateLoaded = true;
            }
        });

        //Button for load the text file
        Button buttonLoadDictionary = new Button("Load dictionary");
        buttonLoadDictionary.setPrefSize(180, 20);
        buttonLoadDictionary.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                isDictionaryLoaded = true;

                //TODO: process dictionary with the saved data

            }
        });

        //This is the debug button
        Button buttonRun = new Button("Translate");
        buttonRun.setPrefSize(100, 20);
        buttonRun.setStyle("-fx-background-color: #388e3c;");
        buttonRun.setOnAction(e -> {

            if(isTextToTranslateLoaded && isDictionaryLoaded){
                //Split the input by lines and store in an Array
                List<String> initLines = Arrays.asList(input.getText().split("\n"));

                for (String line : initLines) {
                    //TODO: Translate each line in this ArrayList, append to result TextArea
                }
            } else {
                //Dictionary and/or text haven't been loaded
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText("Load files");
                alert.setContentText("Text to translate or Dictionary haven't been loaded...");
                alert.showAndWait();

            }

        });

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        result.appendText("Output" + "\n");

        //Button for clear the input data
        Button buttonClear = new Button("Clear");
        buttonClear.setPrefSize(100, 20);
        buttonClear.setOnAction(e -> {
            input.clear();
            result.clear();
            isDictionaryLoaded = isTextToTranslateLoaded = false;
        });

        hbox.getChildren().addAll(buttonLoadDictionary, buttonLoadTextToTranslate, buttonClear, buttonRun);

        return hbox;
    }



    /**
     * For read a file line by line
     *
     * @param file File object which have the math operation
     * @return an ArrayList of String lines of the file
     */
    private ArrayList<String> readFile(File file) {
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                lines.add(text);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BinaryTreeTranslatorView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BinaryTreeTranslatorView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(BinaryTreeTranslatorView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lines;
    }


    /**
     * For add a TextArea to the screen, and show the result
     *
     * @return a filled HBox to add to the UI
     */
    public VBox addVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        //Adding the TextArea to the VBox
        input.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(input);

        result.setFont(Font.font("Arial", FontWeight.MEDIUM, 14));
        vbox.getChildren().add(result);


        return vbox;
    }



}
