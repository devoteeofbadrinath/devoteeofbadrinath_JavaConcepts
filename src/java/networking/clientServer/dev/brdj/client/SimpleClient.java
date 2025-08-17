package java.networking.clientServer.dev.brdj.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {

    public static void main(String[] args) {

        try ( Socket socket = new Socket("localhost", 5000)) {

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output =
                    new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
