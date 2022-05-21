package com.example.chat;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    public TextField messageTextField;
    @FXML
    public Button sendButton;
    @FXML
    public TextArea chatTextArea;
    @FXML
    public ListView usersList;
    private Network network;
    private Chat application;

    public Controller() {
    }

    public void sendMessage() {
        String message = this.messageTextField.getText();
        TextArea var10000 = this.chatTextArea;
        DateFormat var10001 = DateFormat.getTimeInstance();
        Date var10002 = new Date();
        var10000.appendText(var10001.format(var10002) + " ");
        this.messageTextField.requestFocus();
        this.send(message);

        try {
            this.network.sendMessage(message);
        } catch (IOException var3) {
            this.application.showErrorDialog("Ошибка передачи данных по сети");
        }

    }

    public void send(String message) {
        if (!message.isEmpty()) {
            this.chatTextArea.appendText(message);
            this.chatTextArea.appendText(System.lineSeparator());
            this.messageTextField.clear();
        }

    }

    public void setNetwork(Network network) {
        this.network = network;
        network.waitMessages(this::send);
    }

    public void setApplication(Chat application) {
        this.application = application;
    }
}