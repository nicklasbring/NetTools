package PortScanner;

import javafx.scene.control.TextArea;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.Date;

public class Server implements Runnable{

    private int port = 1100;
    private ServerSocket server;
    private Socket socket;
    private TextArea textArea;

    public Server(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void run() {
        try {

            //Opretter ny test server for at teste om portfinderen virker
            server = new ServerSocket(port);
            textArea.appendText("Serveren er startet på port: " + port);
            Date date = new Date();
            textArea.appendText("\nServeren er startet: " + (new Timestamp(date.getTime())));

            //Venter på opkobling fra klient
            socket = server.accept();
            textArea.appendText("\nKlienten er tilsluttet serveren");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
