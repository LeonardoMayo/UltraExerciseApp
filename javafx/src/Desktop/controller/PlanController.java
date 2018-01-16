package Desktop.controller;

import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class PlanController extends Controller implements Initializable{

    private FrameController parent;
    private Map<String, Node> trainingsMap;
    private Node firstModule = null;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void addTrainingModule(String name, Node content) {

        trainingsMap.put(name, content);

        if (firstModule == null) {
            firstModule = content;
        }
    }
}
