package CurrentIP;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ClientController {

    @FXML
    TextArea textArea_ClientResponse;

    public void initialize() {
        Client client = new Client(textArea_ClientResponse);
        Thread threadClient = new Thread(client);
        threadClient.start();
    }
}
