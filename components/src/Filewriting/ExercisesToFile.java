package Filewriting;

import PlanFramework.*;
import java.io.*;
import java.util.ArrayList;

public class ExercisesToFile {

  public ExercisesToFile(){}

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
      writer.write("Date: "+set.getDate()+"; Plan: "+set.getPlan().getName()+"; Repeats: "+set.getRepeats()+";");
      writer.newLine();
    }
    writer.newLine();
    writer.write("::");

    writer.flush();
    writer.close();

  }

  public Exercise readExercise(String exerciseName)throws IOException{

    String dir = System.getProperty("user.dir")+"\\saveddata\\exercises";
    String fileName = exerciseName+".exer";
    File file = new File(dir, fileName);
    BufferedReader reader = new BufferedReader(new FileReader(file));
    int count = lineCount(file);

    String description = null;
    ArrayList<Set> sets = new ArrayList<>();
    boolean setList = false;

    Exercise exercise = new Exercise(exerciseName);

    for (int i = 0; i < count; i++) {
      String line = reader.readLine();
      if (!line.isEmpty()){
        if (setList && !(line.contains("::"))){
          String date = line.substring(6, 17);
          System.out.println(date);
          String planName = line.substring(25, 31);
          //31 is noch falsch. Muss vom Ende der Zeile aus zählen
          Set set = new Set(date, exercise, new Plan(planName));

          sets.add(set);
        }
        if (line.contains("Descritpion: ")){
          description = line.substring(13);
        } else if (line.contains("Sets from Excersize: ")){
          setList = true;
        }
      }
    }

    exercise.setDescription(description);
    exercise.setSets(sets);
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
