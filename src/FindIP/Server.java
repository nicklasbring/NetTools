package FindIP;

import javafx.scene.control.TextArea;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.Date;

public class Server implements Runnable{

    private ServerSocket server;
    private Socket socket;
    private int port = 8000;
    private TextArea textArea;

    public Server(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void run() {
        try {
            //Opretter ny server som kan tilgås på port 8000
            server = new ServerSocket(port);
            textArea.appendText("Serveren er startet på port: " + port);
            Date date = new Date();
            textArea.appendText("\nServeren er startet: " + (new Timestamp(date.getTime())));

            //Venter på opkobling fra klient
            socket = server.accept();
            textArea.appendText("\nKlienten er tilsluttet serveren");


            //String ip = socket.getInetAddress();
            //String hostname = socket.getInetAddress().getHostName();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
