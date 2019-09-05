package TimeServer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ClientController implements Listener{

    @FXML
    TextArea textArea_ClientResponse;

    Client client = new Client(this);

    public void initialize() {
        Thread threadClient = new Thread(client);
        threadClient.start();
        textArea_ClientResponse.appendText("Tryk på knappen for at få tidspunkt");
    }

    @Override
    public void updateTextArea(String msg) {
        textArea_ClientResponse.clear();
        textArea_ClientResponse.appendText(msg + "\n");
    }

    public void requestTime(ActionEvent actionEvent) {
        client.sendRequestToServer(true);
    }
}
