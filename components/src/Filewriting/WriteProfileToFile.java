package Filewriting;

import UserManagement.*;
import PlanFramework.*;
import java.io.*;

public class WriteProfileToFile {

  public WriteProfileToFile(){}

  public void writeProfile(Profile profile) throws IOException {
    String dir = "E:\\Projekte\\UltraExerciseApp\\saveddata\\profiles";
    File file = new File(dir, profile.getName());
    BufferedWriter writer = new BufferedWriter(new FileWriter(file+".exer"));

    //Save Weight and Height to File
    writer.write("Weight: "+profile.getWeight());
    writer.newLine();
    writer.write("Height: "+profile.getHeight());
    writer.newLine();
    writer.write("::");
    writer.newLine();

    //Save connected Plans to File
    writer.write("Plans: "+profile.getPlanList().size()); writer.newLine();
    for (int i = 0; i < profile.getPlanList().size(); i++) {
      Plan plan = profile.getPlanList().get(i);
      writer.write(plan.getName());
      writer.newLine();
    }

    writer.write("::");
    writer.newLine();
    writer.flush();
    writer.close();
  }

}
