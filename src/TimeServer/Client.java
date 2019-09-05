package TimeServer;

import javafx.scene.control.TextArea;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client implements Runnable{

   private Socket socket;
   private int port = 8000;
   private String serverIP = "localhost";
   private DataInputStream inputStream;
   private DataOutputStream outputStream;
   Listener listener;

    public Client(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        try {
            //Anmoder om adgang til serveren på denne pc på port 8000
            socket = new Socket(serverIP, port);

            //Initialiserer mine datainput og dataoutput
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            while (true){
                listener.updateTextArea(inputStream.readUTF());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendRequestToServer(Boolean bool){
        if (bool){
            try {
                outputStream.writeBoolean(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
