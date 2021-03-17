package ht;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TestCliens2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",1234);
        String message = "Hali!";
        PrintWriter printwriter = new PrintWriter(socket.getOutputStream());
        printwriter.println(message);
        printwriter.flush();
        printwriter.close();
        socket.close();
    }

}
