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

  private final int width = 540;

  private final int height = 720;

  private Map<String, Module> modules = new HashMap<>();

  @Override
  public void start(Stage primaryStage) throws Exception {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("../Desktop/fxml/Root.fxml"));
    //System.out.println(getClass().getResource("../Desktop/fxml/Root.fxml"));
    //loader.setLocation(getClass().getResource("Desktop/fxml/Root.fxml"));

    final Parent root = loader.load();
    controller = loader.getController();

    primaryStage.setTitle("Ultra Exercise Test");
    Scene scene = new Scene(root, width, height);
    primaryStage.setMinWidth(width);
    primaryStage.setMinHeight(height);
    primaryStage.setScene(scene);
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
        controller.addModule(name, content);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
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
}


