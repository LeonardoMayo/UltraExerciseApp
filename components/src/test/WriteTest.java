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

        WritePlansToFile planWriter = new WritePlansToFile();
        WriteProfileToFile profileWriter = new WriteProfileToFile();
        WriteExercisesToFile exerciseWriter = new WriteExercisesToFile();
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
}
