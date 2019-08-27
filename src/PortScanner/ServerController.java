package PortScanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class ServerController {

    @FXML
    TextArea textArea_serverResponse;


    public void initialize() {
        Server server = new Server(textArea_serverResponse);
        Thread threadServer = new Thread(server);
        threadServer.start();
    }


}
