package PortScanner;

import java.io.IOException;
import java.net.Socket;

public class ClientPortScanner implements Runnable{

   private Socket socket;
   private String serverIP = "localhost";
   private int interval;
   private int startPort;
   private Listener listener;

   String msg = "";

    public ClientPortScanner(int startPort, int interval, Listener listener) {
        this.interval = interval;
        this.startPort = startPort;
        this.listener = listener;

    }

    @Override
    public void run() {

        for (int port = startPort; port < startPort+interval; port++) {

            if(port %300 == 0){
                System.out.println("jeg er igang " + port);
            }

            try {
                socket = new Socket(serverIP, port);
                msg = "\nPort: " + port + " Er åben på følgende ip: " + serverIP;
                listener.updateTextArea(msg);
                System.out.println("Port: " + port + " Er åben på følgende ip: " + serverIP);
                socket.close();
            } catch (IOException e) {
                //empty catch
            }
        }
        }
    }