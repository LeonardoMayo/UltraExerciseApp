package Desktop;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import Desktop.controller.*;
import Desktop.controller.RootController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class Start extends Application {

  private RootController controller;
  private FrameController frameController;
  private Stage stage;

  private final int width = 540;

  private final int height = 720;

  private Map<String, Module> modules = new HashMap<>();

  private FXMLLoader loader;
  private String selectedProfile;

  public Start(){}

  @Override
  public void start(Stage primaryStage) throws Exception {

    loader = new FXMLLoader(getClass().getResource("../Desktop/fxml/Root.fxml"));
    //System.out.println(getClass().getResource("../Desktop/fxml/Root.fxml"));
    //loader.setLocation(getClass().getResource("Desktop/fxml/Root.fxml"));

    final Parent root = loader.load();
    controller = loader.getController();
    controller.startInstance = this;

    primaryStage.setTitle("Ultra Exercise Test");
    Scene scene = new Scene(root, width, height);
    primaryStage.setMinWidth(width);
    primaryStage.setMinHeight(height);
    primaryStage.setScene(scene);
    stage = primaryStage;
    primaryStage.show();

//    addModule("Frame");
//    addModule("Login");
//    addModule("Registration");

    //controller.startUp();

  }

  private void addModule(String name) {
    try {
      URL url = getClass().getResource("../Desktop/fxml/" + name + ".fxml");
      if (url == null) {
        System.out.println("ERROR 404 - addModule: Fxml File for Module: \"" + name + "\" not found!");
      } else {
        System.out.println("INFO - addModule: Loading Module: \"" + name + "\"!");
        Node content = FXMLLoader.load(url);
        frameController.addModule(name, content);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void loadFrame() throws Exception {
    loader = new FXMLLoader(getClass().getResource("../Desktop/fxml/Frame.fxml"));
    final Parent root = loader.load();
    frameController = loader.getController();
    frameController.setSelectedProfileName(selectedProfile);
    Scene scene = new Scene(root, width, height);
    stage.setScene(scene);
    stage.show();

    addModule("Profile");
    addModule("Plan");

    frameController.startUp();

  }

  /**
   * the main method.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {

    System.out.println("java version: " + System.getProperty("java.version"));
    launch(args);
  }

  public void setSelectedProfile(String name){
    selectedProfile = name;
  }
}


