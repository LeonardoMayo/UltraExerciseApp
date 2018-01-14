package Filewriting;

import PlanFramework.*;
import java.io.*;

public class WriteExercisesToFile {

  public WriteExercisesToFile(){}

  public void writeExcersize(Exercise exercise) throws IOException {
    String dir = System.getProperty("user.dir")+"\\saveddata\\exercises";
    File file = new File(dir, exercise.getName());
    BufferedWriter writer = new BufferedWriter(new FileWriter(file+".exer"));

    //Save Description to File
    writer.write("Description: "+exercise.getDescription());
    writer.newLine();
    writer.write("::");
    writer.newLine();

    //Save Sets to file
    writer.write("Sets from Excersize: "+exercise.getSets().size());
    writer.newLine();
    for (int i = 0; i < exercise.getSets().size(); i++) {
      Set set = exercise.getSets().get(i);
      writer.write("Date: "+set.getDate()+"; Plan: "+set.getPlan()+"; Repeats: "+set.getRepeats()+";");
      writer.newLine();
    }
    writer.newLine();
    writer.write("::");

    writer.flush();
    writer.close();

  }

  public Exercise readExercise(String exerciseName){
    Exercise exercise = new Exercise(exerciseName);
    return exercise;
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
