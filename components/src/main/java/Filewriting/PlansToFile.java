package Filewriting;

import PlanFramework.*;
import UserManagement.Profile;

import java.io.*;
import java.util.ArrayList;

public class PlansToFile {

  public Profile currentUser;

  public PlansToFile(){}

  public void writePlan(Plan plan) throws IOException {
    String dir = System.getProperty("user.dir")+"\\saveddata\\"+currentUser.getName()+"\\plans";
    File file = new File(dir, plan.getName());
    BufferedWriter writer = new BufferedWriter(new FileWriter(file+".exer"));

    //Save Plan Description
    writer.write("Description: "+plan.getDescription());
    writer.newLine();
    writer.write("::");
    writer.newLine();

    //Saving Trainig Dates
    writer.write("Training Dates: "+plan.getTrainingDates().size()); writer.newLine();
    for (int i = 0; i < plan.getTrainingDates().size(); i++) {
      writer.write(plan.getTrainingDates().get(i));
      writer.newLine();
    }
    writer.write("::");
    writer.newLine();

    //Save Exercise Names connected to Plan
    writer.write("Exercises: "+plan.getExerciseList().size()); writer.newLine();
    for (int i = 0; i < plan.getExerciseList().size(); i++) {
      Exercise exercise = plan.getExerciseList().get(i);
      writer.write(exercise.getName());
      writer.newLine();
    }
    writer.write("::");
    writer.newLine();

    writer.flush();
    writer.close();
  }

  public Plan readPlan(String planName){

    String dir = System.getProperty("user.dir")+"\\saveddata\\"+currentUser.getName()+"\\plans";
    String fileName = planName+".exer";
    File file = new File(dir, fileName);
    BufferedReader reader = null;
    int count = 0;
    try {
      reader = new BufferedReader(new FileReader(file));
      count = lineCount(file);
    } catch (FileNotFoundException e) {
      //e.printStackTrace();
      return null;
    } catch (IOException e) {
      //e.printStackTrace();
    }


    String description = null;
    ArrayList<Exercise> exercises = new ArrayList<>();
    ArrayList<String> trainingDates = new ArrayList<>();
    boolean exerciseList = false;
    boolean trainingDatesList = false;

    for (int i = 0; i < count; i++) {
      String line = null;
      try {
        line = reader.readLine();
      } catch (IOException e) {
        //e.printStackTrace();
      }

      if (trainingDatesList && !(line.contains("::"))){
        trainingDates.add(line);
      }
      if (exerciseList && !(line.contains("::"))){
        Exercise exercise = new Exercise(line);
        exercises.add(exercise);
      }

      if (line.contains("Description: ")){
        description = line.substring(13);
      } else if (line.contains("Training Dates: ")){
        trainingDatesList = true; exerciseList = false;
      } else if (line.contains("Exercises: ")){
        trainingDatesList = false; exerciseList = true;
      }
    }

    Plan plan = new Plan(planName);
    plan.setDescription(description);
    plan.setExerciseList(exercises);
    plan.setTrainingDates(trainingDates);
    return plan;
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

  public Profile getCurrentUser() {
    return currentUser;
  }

  public void setCurrentUser(Profile currentUser) {
    this.currentUser = currentUser;
  }
}
