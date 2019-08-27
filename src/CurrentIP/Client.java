package CurrentIP;

import javafx.scene.control.TextArea;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client implements Runnable{

   private Socket socket;
   private int port = 8000;
   private String serverIP = "localhost";
   private TextArea textArea;

    public Client(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void run() {
        try {
            //Anmoder om adgang til serveren på denne pc på port 8000
            socket = new Socket(serverIP, port);
            textArea.appendText("Beder om adgang til server: '" + serverIP + "' På port: " + port);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
