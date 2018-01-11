import PlanFramework.Plan;
import java.util.ArrayList;

/**
 * @author Jan Leppich
 * @version 2018-01-11
 */

public class Profile {

  private String name;
  private int weight;
  private int height;
  private ArrayList<Plan> planList = new ArrayList<>();

  public Profile(String name) {
    this.name = name;
  }

  public Profile(String name, int weight) {
    this.name = name;
    this.weight = weight;
  }

  public Profile(String name, int weight, int height) {
    this.name = name;
    this.weight = weight;
    this.height = height;
  }

  public void addPlanToProfile (Plan plan){
    planList.add(plan);
  }

  public void removePlanFromProfile (Plan plan){
    planList.remove(plan);
  }

  public void changePlanPositionInProfile(Plan plan){
    /**
     * Can be tinkered with when the other stuff works
     */
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }
}
