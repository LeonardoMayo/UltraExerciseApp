package Desktop.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Jan on 16.01.2018.
 */


public class RootController extends Controller implements Initializable {

    @FXML
    private AnchorPane modulePane;


    private Map<String, Node> moduleMap;
    private Node firstModule = null;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

        modulePane.getChildren().clear();

        modulePane.getChildren().add(moduleMap.get("Login"));
    }

    public void addModule(String name, Node content) {

        moduleMap.put(name, content);

        if (firstModule == null) {
            firstModule = content;
        }
    }




}
