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
          String date = line.substring(6, 16);
          String planName = line.substring(25, 31);
          //31 is noch falsch. Muss vom Ende der Zeile aus zählen
          Set set = new Set(date, exercise, new Plan(planName));
          ArrayList<Integer> repeats = loadNormalRepeats(line);
          set.setRepeats(repeats);
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

  public ArrayList<Integer> loadNormalRepeats(String line){
    ArrayList<Integer> repeats = new ArrayList<>();
    int start = 0; int end = 0;
    for (int i = 0; i < line.length(); i++) {
      if ("[".equals(String.valueOf(line.charAt(i)))){
        start = i;
      } else if ("]".equals(String.valueOf(line.charAt(i)))){
        end = i;
      }
    }
    String stringWithRepetitions = line.substring(start+1, end);
    for (int i = 0; i < stringWithRepetitions.length(); i++) {
      String number = null;
      String char0 = " ";
      if (i != 0){
        char0 = String.valueOf(stringWithRepetitions.charAt(i-1));
      }
      String char1 = String.valueOf(stringWithRepetitions.charAt(i));
      String char2 = ",";
      if (i != stringWithRepetitions.length()-1){
        char2 = String.valueOf(stringWithRepetitions.charAt(i+1));
      }

      if (!(char0.matches("\\d{1}") || char1.equals(",") || char1.equals(" "))){
        number = String.valueOf(stringWithRepetitions.charAt(i));
        if (!(char2.equals(","))){
          number += String.valueOf(stringWithRepetitions.charAt(i+1));
        }
      }

      if (number != null){
        repeats.add(Integer.parseInt(number));
      }
    }
    return repeats;
  }

  public ArrayList<Integer> loadEnduranceRepeats(String line){
    return null;
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
