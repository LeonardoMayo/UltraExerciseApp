package Filewriting;

import PlanFramework.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WritePlansToFile {

  public WritePlansToFile(){}

  public void writePlan(Plan plan) throws IOException {
    String dir = "E:\\Projekte\\UltraExerciseApp\\saveddata\\plans";
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

  public void readPlan(){

  }

}
