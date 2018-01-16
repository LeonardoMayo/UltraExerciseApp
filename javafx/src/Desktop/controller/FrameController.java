package Desktop.controller;

import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Jan on 15.01.2018.
 */
public class FrameController extends Controller implements Initializable{

    private RootController parent;
    private Map<String, Node> moduleMap;
    private Node firstModule = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void addModule(String name, Node content) {

        moduleMap.put(name, content);

        if (firstModule == null) {
            firstModule = content;
        }
    }
}
