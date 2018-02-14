package PlanFramework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Jan Leppich
 * @version 2018-01-11
 */

public class Plan {

  private String name;
  private String description;
  private ArrayList<Exercise> exerciseList = new ArrayList<>();
  private ArrayList<String> trainingDates = new ArrayList<>();
  private ArrayList<Set> allSetsInPlan = new ArrayList<>();

  public Plan (String name){
    this.name = name;
  }

  public Plan (String name, String description){
    this.name = name;
    this.description = description;
  }

  public void addExerciseToPlan (Exercise exercise){
    exerciseList.add(exercise);
  }

  public void removeExerciseFromPlan (Exercise exercise){
    exerciseList.remove(exercise);
  }

  public void addDateToPlan (String date){
    trainingDates.add(date);
  }

  public void removeDateFromPlan (String date){
    trainingDates.remove(date);
  }

  /*
  Methods to save Training data
   */
  public void saveExerciseSets (Exercise exercise, String Set){

  }

  public void newTraining(Plan plan) {

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date currentDate = new Date();
    String date = dateFormat.format(currentDate);

    plan.addDateToPlan(date);

    for (int i = 0; i < plan.getExerciseList().size(); i++) {
      Exercise exercise = plan.getExerciseList().get(i);
      Set set = new Set(date, exercise, plan);
      exercise.addSetToExercise(set);
    }

  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ArrayList<Exercise> getExerciseList() {
    return exerciseList;
  }

  public void setExerciseList(ArrayList<Exercise> exerciseList) {
    this.exerciseList = exerciseList;
  }

  public ArrayList<String> getTrainingDates() {
    return trainingDates;
  }

  public void setTrainingDates(ArrayList<String> trainingDates) {
    this.trainingDates = trainingDates;
  }
}
