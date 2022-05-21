package Lesson6_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Homework_6_2 {
    public static void main(String[] args) throws IOException {
        new Homework_6_2().start("localhost", 5000);
    }

    public void start(String host, int port) {
        Thread inputThread = null;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Клиент запущен");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            inputThread = runInputLoop(dataInputStream);
            runOutputLoop(dataOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputThread != null) {
                inputThread.interrupt();
            }
        }
    }

    private Thread runInputLoop(DataInputStream dataInputStream) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String message = dataInputStream.readUTF();
                    System.out.println("Сервер: " + message);
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