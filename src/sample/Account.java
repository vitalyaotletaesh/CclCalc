package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class Account {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane account;

    @FXML
    void initialize() {
        assert account != null : "fx:id=\"account\" was not injected: check your FXML file 'account.fxml'.";

    }
}

