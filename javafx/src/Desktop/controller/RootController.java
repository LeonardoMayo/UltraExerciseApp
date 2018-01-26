package Desktop.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.HashMap;
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

  private LoginController loginController;
  private RegistrationController registrationController;
  private FrameController frameController;

  public RootController() {
    System.out.println("RootController created");
    moduleMap = new HashMap<>();
  }

  @Override
  public void initialize(final URL location, final ResourceBundle resources) {

//        modulePane.getChildren().clear();
//
//        if (!moduleMap.isEmpty()){
//            modulePane.getChildren().add(moduleMap.get("Login"));
//        }
//        modulePane.getChildren().add(firstModule);

  }

  public void addModule(String name, Node content) {

    moduleMap.put(name, content);

    if (firstModule == null) {
      firstModule = content;
    }
  }

  public void startUp() {
    modulePane.getChildren().clear();
    modulePane.getChildren().add(moduleMap.get("Login"));
    //wie krieg ich hier den Controller von Login?

  }


  public void changeToRegistrationModule() {
    modulePane.getChildren().clear();
    modulePane.getChildren().add(moduleMap.get("Registration"));
  }

  public void changeToFrameModule() {
    modulePane.getChildren().clear();
    modulePane.getChildren().add(moduleMap.get("Frame"));
  }
}
