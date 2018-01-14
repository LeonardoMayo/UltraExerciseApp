import test.LaunchTest;
import test.ReadTest;
import test.WriteTest;

import java.io.IOException;

public class Main {

  public static void main(String[] args) {

//    WriteTest writeTest = new WriteTest();
//    writeTest.init();

    ReadTest readTest = new ReadTest();
    try {
      readTest.init();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}