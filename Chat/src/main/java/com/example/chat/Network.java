package com.example.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.function.Consumer;

public class Network {
    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 3000;
    private final String host;
    private final int port;
    private Socket socket;
    private DataInputStream socketInput;
    private DataOutputStream socketOutput;

    public Network(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Network() {
        this(SERVER_HOST, SERVER_PORT);
    }

    public boolean connect() {
        try {
            this.socket = new Socket(this.host, this.port);
            this.socketInput = new DataInputStream(this.socket.getInputStream());
            this.socketOutput = new DataOutputStream(this.socket.getOutputStream());
            return true;
        } catch (IOException var2) {
            var2.printStackTrace();
            return false;
        }
    }

    public void sendMessage(String message) throws IOException {
        try {
            this.socketOutput.writeUTF(message);
        } catch (IOException var3) {
            System.err.println("Не удалось отправить сообщение на сервер");
            throw var3;
        }
    }

    public void waitMessages(Consumer<String> messageHandler) {
        Thread thread = new Thread(() -> {
            while(true) {
                try {
                    String message = this.socketInput.readUTF();
                    messageHandler.accept(message);
                } catch (IOException var3) {
                    System.err.println("Не удалось получить сообщение от сервера");
                    return;
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    public void close() {
        try {
            this.socket.close();
        } catch (IOException var2) {
            System.err.println("Не удалось закрыть сетевое соединение");
        }

    }
}