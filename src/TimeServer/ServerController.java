package TimeServer;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


public class ServerController {

    @FXML
    TextArea textArea_serverResponse;

    public void initialize() {
        Server server = new Server();
        Thread threadServer = new Thread(server);
        threadServer.start();
    }
}
