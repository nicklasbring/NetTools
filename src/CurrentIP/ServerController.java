package CurrentIP;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


public class ServerController {

    @FXML
    TextArea textArea_serverResponse;

    public void initialize() {
        Server server = new Server(textArea_serverResponse);
        Thread threadServer = new Thread(server);
        threadServer.start();
    }
}
