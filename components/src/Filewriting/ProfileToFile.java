package Filewriting;

import UserManagement.*;
import PlanFramework.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProfileToFile {

  public ProfileToFile(){}

  public void writeProfile(Profile profile) throws IOException {
    String dir = System.getProperty("user.dir")+"\\saveddata\\profiles";
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

  public Profile readProfile(String profileName) throws IOException {
    String dir = System.getProperty("user.dir")+"\\saveddata\\profiles";
    String fileName = profileName+".exer";
    File file = new File(dir, fileName);
    BufferedReader reader = new BufferedReader(new FileReader(file));

    int count = lineCount(file);

    String name = profileName;
    int weight = 0;
    int height = 0;
    ArrayList<Plan> plans = new ArrayList<>();
    boolean planList = false;

    for (int i = 0; i < count; i++) {
      String line = reader.readLine();

      if (planList && !(line.contains("::"))){
        Plan plan = new Plan(line);
        plans.add(plan);
      }

      if (line.contains("Weight: ")){
        weight = Integer.parseInt(line.substring(8));
      } else if (line.contains("Height: ")){
        height = Integer.parseInt(line.substring(8));
      } else if (line.contains("Plans: ")){
        planList = true;
      }
    }

    Profile profile = new Profile(name, weight, height);
    profile.setPlanList(plans);
    return profile;
  }

  public int lineCount(File file) throws IOException {
    LineNumberReader reader  = new LineNumberReader(new FileReader(file));
    int cnt = 0;
    String lineRead = "";
    while ((lineRead = reader.readLine()) != null) {}

    cnt = reader.getLineNumber();
    reader.close();
    return cnt;
  }
  }


