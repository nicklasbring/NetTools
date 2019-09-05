package TimeServer;

import javafx.scene.control.TextArea;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.Date;

public class Server implements Runnable{

    private ServerSocket server;
    private Socket socket;
    private int port = 8000;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;


    public Server() {
    }

    @Override
    public void run() {
        try {
            //Opretter ny server som kan tilgås på port 8000
            server = new ServerSocket(port);

            //Venter på opkobling fra klient
            socket = server.accept();
            System.out.println("Klient tilsluttet server");

            //Initialisere min datainput og dataoutput
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            while (true){
                boolean bool = inputStream.readBoolean();
                if (bool){
                    Date date = new Date();
                    outputStream.writeUTF("Dato og tidspunkt: " + date.toString());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
