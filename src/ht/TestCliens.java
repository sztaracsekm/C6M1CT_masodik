package ht;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TestCliens {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",1234);
        String message = "Mennyi az idő?";
        PrintWriter printwriter = new PrintWriter(socket.getOutputStream());
        printwriter.println(message);
        printwriter.flush();
        printwriter.close();
        socket.close();
    }
}
