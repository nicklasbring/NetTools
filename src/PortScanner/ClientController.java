package PortScanner;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ClientController implements Listener {

    @FXML
    TextArea textArea_ClientResponse;

    public void initialize() {
        MultiThreads multiThreads = new MultiThreads(this);
        Thread thread = new Thread(multiThreads);
        thread.start();
        updateTextArea("Scanner for åbne porte...");
    }


    @Override
    public void updateTextArea(String msg) {
        Platform.runLater(() ->
                textArea_ClientResponse.appendText(msg + "\n"));

    }
}