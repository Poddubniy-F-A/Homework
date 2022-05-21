package com.example.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 3000;

    public Server() {
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            try {
                System.out.println("Сервер начал работу, ожидает подключений");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Клиент подключился");
                DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
                processClientConnection(dataInputStream, dataOutputStream);
            } catch (Throwable var6) {
                try {
                    serverSocket.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            serverSocket.close();
        } catch (IOException var7) {
            System.err.println("Ошибка при подключении к порту 3000");
            var7.printStackTrace();
        }

    }

    private static void processClientConnection(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        while(true) {
            try {
                String message = dataInputStream.readUTF();
                if (!message.startsWith("/end")) {
                    dataOutputStream.writeUTF("Эхо: " + message);
                    continue;
                }
            } catch (IOException var3) {
                System.err.println("Сетевое соединение было закрыто");
            }

            return;
        }
    }
}