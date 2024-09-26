import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000); // Port number

            while (true) {
                Socket socket = serverSocket.accept(); // Accept incoming connections

                // Create a new thread for each client
                ClientThread clientThread = new ClientThread(socket);
                new Thread(clientThread).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientThread implements Runnable {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public ClientThread(Socket socket) {
        this.socket = socket;
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = input.readLine(); // Read client messages
                if (message.equals("exit")) {
                    break;
                }
                // Broadcast message to all clients
                broadcastMessage(message);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void broadcastMessage(String message) {
        // To be implemented: Send the message to all connected clients
        // For example, store all output streams of clients in a list and send message to each one
    }
}

