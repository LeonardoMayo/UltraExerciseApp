package Desktop;

import Desktop.controller.*;

public class Module {

  private String name;
  private Controller controller;

  public Module(String name, Controller controller) {
    this.name = name;
    this.controller = controller;
  }
}
