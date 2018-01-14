package test;

import Filewriting.*;
import PlanFramework.*;
import UserManagement.*;

import java.io.IOException;

public class WriteTest {

    private Profile user;
    private Plan plan1;
    private Plan plan2;
    private Exercise exer1;
    private Exercise exer2;
    private Exercise exer3;
    private Exercise exer4;
    private Exercise exer5;
    LaunchTest launchTest = new LaunchTest();
    public WriteTest() {
    }

    public void init() {

        user = new Profile("MasterBeater69", 90, 180);
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

        addSetsForTests(exer1);
        addSetsForTests(exer2);
        addSetsForTests(exer3);
        addSetsForTests(exer4);
        addSetsForTests(exer5);

        PlansToFile planWriter = new PlansToFile();
        ProfileToFile profileWriter = new ProfileToFile();
        ExercisesToFile exerciseWriter = new ExercisesToFile();
        try {
            profileWriter.writeProfile(user);
            planWriter.writePlan(plan1);
            planWriter.writePlan(plan2);
            exerciseWriter.writeExcersize(exer1);
            exerciseWriter.writeExcersize(exer2);
            exerciseWriter.writeExcersize(exer3);
            exerciseWriter.writeExcersize(exer4);
            exerciseWriter.writeExcersize(exer5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillTestSets(Set set) {
        set.addRepetitionToSet((int) (Math.random()*10));
        set.addRepetitionToSet((int) (Math.random()*10));
        set.addRepetitionToSet((int) (Math.random()*10));
    }

    private void addSetsForTests(Exercise exercise){
        for (int i = 0; i < 3; i++) {
            Set set = new Set(launchTest.getActualDate(), exercise, plan1);
            exercise.addSetToExercise(set);
            fillTestSets(set);
        }
    }
}
