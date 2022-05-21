package Lesson6_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
        new Server().start(PORT);
    }

    public void start(int port) throws IOException {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        Thread inputThread = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Сервер запущен");
            clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

            inputThread = runInputLoop(dataInputStream);
            runOutputLoop(dataOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputThread != null) {
                inputThread.interrupt();
            }
            if (clientSocket != null) {
                clientSocket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private Thread runInputLoop(DataInputStream dataInputStream) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String message = dataInputStream.readUTF();
                    System.out.println("Клиент: " + message);
                    if (message.startsWith("/end")) {
                        System.exit(0);
                    }
                } catch (IOException e) {
                    System.out.println("Подключение прервано");
                    System.exit(0);
                    break;
                }
            }
        });
        thread.start();
        return thread;
    }

    private void runOutputLoop(DataOutputStream dataOutputStream) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            if (message.startsWith("/end")) {
                break;
            }
            dataOutputStream.writeUTF(message);
        }
    }
}
