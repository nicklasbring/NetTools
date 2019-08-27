package PortScanner;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ClientController {

    @FXML
    TextArea textArea_ClientResponse;

    public void initialize() {
        MultiThreads multiThreads = new MultiThreads();
        Thread thread = new Thread(multiThreads);
        thread.start();

    }
}
    /*ClientPortScanner clientPortScanner = new ClientPortScanner(textArea_ClientResponse);
    Thread threadClient = new Thread(clientPortScanner);
        threadClient.start();*/