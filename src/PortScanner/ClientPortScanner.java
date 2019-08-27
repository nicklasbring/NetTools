package PortScanner;

import java.io.IOException;
import java.net.Socket;

public class ClientPortScanner implements Runnable{

   private Socket socket;
   private String serverIP = "localhost";
   private int interval;
   private int startPort;

    public ClientPortScanner(int startPort, int interval) {
        this.interval = interval;
        this.startPort = startPort;

    }

    @Override
    public void run() {

        for (int port = startPort; port < startPort+interval; port++) {

            if(port %300 == 0){
                System.out.println("jeg er igang " + port);
            }

            try {
                socket = new Socket(serverIP, port);
                System.out.println("\nPort: " + port + " Er åben på følgende ip: " + serverIP);
                socket.close();
            } catch (IOException e) {
                //empty catch
            }
        }

        }
    }