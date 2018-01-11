package PlanFramework;
import java.util.ArrayList;

/**
 * @author Jan Leppich
 * @version 2018-01-11
 */

public class Exercise {

  private String name;
  private String description;
  private ArrayList<Set> sets = new ArrayList<>();

  public Exercise (String name){
    this.name = name;
  }

  public Exercise (String name, String description){
    this.name = name;
    this.description = description;
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

  public void addSetToExercise(Set set){
    sets.add(set);
  }

  public ArrayList<Set> getSets() {
    return sets;
  }

  public void setSets(ArrayList<Set> sets) {
    this.sets = sets;
  }
}
