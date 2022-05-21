package com.example.chat;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Chat extends Application {
    private Stage stage;

    public Chat() {
    }

    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Chat.class.getResource("Scheme.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        this.stage.setTitle("Чат");
        this.stage.setScene(scene);
        Controller controller = fxmlLoader.getController();
        controller.usersList.getItems().addAll("Пользователь1", "Пользователь2");
        stage.show();
        this.connectToServer(controller);
    }

    private void connectToServer(Controller clientController) {
        Network network = new Network();
        boolean resultConnectedToServer = network.connect();
        if (!resultConnectedToServer) {
            String errorMessage = "Невозможно установить сетевое соединение";
            System.err.println(errorMessage);
            this.showErrorDialog(errorMessage);
        }

        clientController.setNetwork(network);
        clientController.setApplication(this);
        this.stage.setOnCloseRequest((windowEvent) -> network.close());
    }

    public void showErrorDialog(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}