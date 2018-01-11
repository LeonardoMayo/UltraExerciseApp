package PlanFramework;

import java.util.ArrayList;

public class Set {

  private String date;
  private Exercise exercise;
  private Plan plan;
  private ArrayList<Integer> repeats = new ArrayList<>();

  public Set (String date, Exercise exercise, Plan plan){
    this.date = date;
    this.exercise = exercise;
    this.plan = plan;
  }

  public void addRepetitionToSet (int rep){
    repeats.add(rep);
  }
  public void removeRepetitionFromSet (int rep, int pos){
    repeats.remove(pos);
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Exercise getExercise() {
    return exercise;
  }

  public void setExercise(Exercise exercise) {
    this.exercise = exercise;
  }

  public Plan getPlan() {
    return plan;
  }

  public void setPlan(Plan plan) {
    this.plan = plan;
  }

  public ArrayList<Integer> getRepeats() {
    return repeats;
  }

  public void setRepeats(ArrayList<Integer> repeats) {
    this.repeats = repeats;
  }
}
