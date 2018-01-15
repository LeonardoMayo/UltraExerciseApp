package test;

import PlanFramework.*;
import Filewriting.*;
import UserManagement.Profile;
import java.io.IOException;

/**
 * @author Jan Leppich
 * @version 2018-01-11
 */

public class LaunchTest {

  private Profile user;
  private Plan plan1;
  private Plan plan2;
  private Exercise exer1;
  private Exercise exer2;
  private Exercise exer3;
  private Exercise exer4;
  private Exercise exer5;

  public LaunchTest() {
  }

  public void init() {
    user = new Profile("MasterBeater69");
    plan1 = new Plan("Brust");
    plan2 = new Plan("Bauch");

    exer1 = new Exercise("Bankdrücken");
    exer2 = new Exercise("Überzüge");
    exer3 = new Exercise("Sit-Ups");
    exer4 = new Exercise("Crunshes");
    exer5 = new Exercise("Sit-Ups seitlich");

    user.addPlanToProfile(plan1);
    user.addPlanToProfile(plan2);

    plan1.addExerciseToPlan(exer1);
    plan1.addExerciseToPlan(exer2);

    plan2.addExerciseToPlan(exer3);
    plan2.addExerciseToPlan(exer4);
    plan2.addExerciseToPlan(exer5);

    newTraining(plan1);
    newTraining(plan2);

    TestSetAdress(exer1);

  }

  private void TestSetAdress(Exercise exercise) {
    for (int i = 0; i < 3; i++) {
      Set set = new Set(getActualDate(), exercise, plan1);
      exercise.addSetToExercise(set);
      fillTestSets(set);
    }
    System.out.println(exercise.getName()+": Sets");
    for (int i = 0; i < exercise.getSets().size(); i++) {
      System.out.println(exercise.getSets().get(i).getDate()+": "+exercise.getSets().get(i).getRepeats());
    }
  }

  public String getActualDate() {
    return "2018-01-12";
  }

  public void newTraining(Plan plan) {

    plan.addDateToPlan(getActualDate());

    for (int i = 0; i < plan.getExerciseList().size(); i++) {
      Exercise exercise = plan.getExerciseList().get(i);
      Set set = new Set(getActualDate(), exercise, plan);
      exercise.addSetToExercise(set);
      fillTestSets(set);
    }

    printTestData(plan);
  }

  public void fillTestSets(Set set) {
    set.addRepetitionToSet((int) (Math.random()*10));
    set.addRepetitionToSet((int) (Math.random()*10));
    set.addRepetitionToSet((int) (Math.random()*10));
  }

  public void printTestData(Plan plan) {
    System.out.println("--- Print Test Data: " + plan.getName() + " ---");
    System.out.println("Exercises in " + plan.getName() + ": " + plan.getExerciseList().size());
    for (int i = 0; i < plan.getExerciseList().size(); i++) {
      Exercise exercise = plan.getExerciseList().get(i);
      System.out.println("Sets in "+exercise.getName()+": "+exercise.getSets().size());
      for (int j = 0; j < exercise.getSets().size(); j++) {
        Set set = exercise.getSets().get(j);
        System.out.println(set.getDate()+": "+set.getRepeats());
      }
    }
    System.out.println("--- End Test Data ---");
  }
}
