package Desktop.controller;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import Filewriting.*;
import PlanFramework.*;
import UserManagement.*;
import javafx.scene.layout.AnchorPane;


import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Jan on 15.01.2018.
 */
public class FrameController extends Controller implements Initializable{

    public AnchorPane modulePane;

    private Map<String, Node> moduleMap;
    private Node firstModule = null;
    private String selectedProfileName;

    public FrameController(){
        System.out.println("FrameController created");
        moduleMap = new HashMap<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void startUp() {
        modulePane.getChildren().clear();
        modulePane.getChildren().add(moduleMap.get("Profile"));
    }

    public void addModule(String name, Node content) {

        moduleMap.put(name, content);

        if (firstModule == null) {
            firstModule = content;
        }
    }

    public void loadProfileAndPlans(String selectedProfileName){

    }

    public String getSelectedProfileName() {
        return selectedProfileName;
    }

    public void setSelectedProfileName(String selectedProfileName) {
        this.selectedProfileName = selectedProfileName;
    }



    public void loadProfileModule(){

    }

    public void loadPlanModule(){

    }
}
