package FindIP;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Starter min server gui
        Stage secondaryStage = new Stage();
        Parent server = FXMLLoader.load(getClass().getClassLoader().getResource("FindIP/ServerFxml.fxml"));
        primaryStage.setTitle("Server");
        primaryStage.setScene(new Scene(server, 600, 400));
        primaryStage.show();

        //Starter min Client gui
        Parent client = FXMLLoader.load(getClass().getClassLoader().getResource("FindIP/ClientFxml.fxml"));
        secondaryStage.setTitle("Client");
        secondaryStage.setScene(new Scene(client, 600, 400));
        secondaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
