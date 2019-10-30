import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(14587))
        {
            out.println("Server started");

            while (true)
            try(
                    Socket socket = server.accept();

                    BufferedWriter writer =
                            new BufferedWriter(
                                    new OutputStreamWriter(
                                            socket.getOutputStream()));

                    BufferedReader reader =
                            new BufferedReader(
                                    new InputStreamReader(
                                            socket.getInputStream()));
                    ) {
                String requets = reader.readLine();
                out.println("Request is: " + requets);

                String response = "Hello from server!";
                out.println("Response: " + response);

                writer.write(response);
                writer.newLine();
                writer.flush();
            }

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
