package Desktop.controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Jan on 15.01.2018.
 */
public class LoginController extends Controller implements Initializable {

  private RootController parent;

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }

  public void login(String profileName) {
    parent.changeToFrameModule();
  }

  public void changeToRegistration() {
    parent.changeToRegistrationModule();
  }

  public void setParent(RootController parent) {
    this.parent = parent;
  }

  public RootController getParent() {
    return parent;
  }
}
