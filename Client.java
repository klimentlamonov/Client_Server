import java.io.*;
import java.net.Socket;

import static java.lang.System.out;

public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("192.168.56.101", 14587);
                BufferedWriter writer =
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream()));

                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        socket.getInputStream()));
                ) {
            out.println("Connected to server!");
            String request = "Knock - knock";
            out.println("Request: " + request);

            writer.write(request);
            writer.newLine();
            writer.flush();

            String response = reader.readLine();
            out.println("Response: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
