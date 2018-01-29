package Desktop.controller;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import UserManagement.Profile;

/**
 * Created by Jan on 16.01.2018.
 */


public class RootController extends Controller implements Initializable {

  @FXML
  public AnchorPane loginPane;
  public AnchorPane registrationPane;
  public AnchorPane modulePane;
  public Button loginButton;
  public Button goToRegister;
  public ListView profileList;

  public TextField registrationNameField;
  public TextField registrationHeightField;
  public TextField registrationWeightField;
  public Button registrationButton;


  private Map<String, Node> moduleMap;
  private Node firstModule = null;

  private String dir = System.getProperty("user.dir") + "\\saveddata\\";

  public RootController() {
    System.out.println("RootController created");
    moduleMap = new HashMap<>();
  }

  @Override
  public void initialize(final URL location, final ResourceBundle resources) {

    loginPane.setVisible(true);
    ArrayList<Profile> profiles = loadProfiles(dir + "profiles");
    profileList.setItems((ObservableList) profiles);

  }

  public void addModule(String name, Node content) {

    moduleMap.put(name, content);
    if (firstModule == null) {
      firstModule = content;
    }
  }


  public void changeToRegistrationModule() {

    loginPane.setVisible(false);
    registrationPane.setVisible(true);

  }

  public void changeToFrameModule() {
    //modulePane.getChildren().clear();
    loginPane.setVisible(false);
    registrationPane.setVisible(false);
    modulePane.getChildren().add(moduleMap.get("Frame"));
  }

  public ArrayList<Profile> loadProfiles(String path) {
    return null;
  }
}
