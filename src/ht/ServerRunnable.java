package ht;

import java.io.*;
import java.net.Socket;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class ServerRunnable  implements Runnable{
    private Socket socket;

    public ServerRunnable(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = bufferedReader.readLine();
            Log(message);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void Log(String message) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream("serverlog\\log.txt",true));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        LocalDateTime actualTime = LocalDateTime.now();

        printWriter.print(dateTimeFormatter.format(actualTime) + " - " + message +"\n");
        printWriter.flush();
        printWriter.close();
    }
}
