package com.example.chat;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.DateFormat;
import java.util.Date;

public class Controller {

    @FXML
    public TextField messageTextField;

    @FXML
    public Button sendButton;

    @FXML
    public TextArea chatTextArea;

    @FXML
    public ListView usersList;

    public void send() {
        if (!messageTextField.getText().isEmpty()) {
            chatTextArea.appendText(DateFormat.getDateTimeInstance().format(new Date()));
            chatTextArea.appendText(System.lineSeparator());
            if (!usersList.getSelectionModel().isEmpty()) {
                chatTextArea.appendText(usersList.getSelectionModel().getSelectedItem().toString());
            } else {
                chatTextArea.appendText("Me");
            }
            chatTextArea.appendText(": ");
            chatTextArea.appendText(messageTextField.getText().trim());
            chatTextArea.appendText(System.lineSeparator());
            requestFocus();
            messageTextField.clear();
        }
    }

    private void requestFocus () {
        Platform.runLater(() -> messageTextField.requestFocus());
    }
}