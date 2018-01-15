package test;

import PlanFramework.*;
import UserManagement.*;

import java.io.*;

/**
 * Created by Jan on 15.01.2018.
 */
public class LoadAndWriteTest {

    ReadTest readTest = new ReadTest();
    WriteTest writeTest = new WriteTest();
    LaunchTest launchTest = new LaunchTest();

    public LoadAndWriteTest() {
    }

    public void run() throws IOException {
        Profile user = readTest.loadCompleteProfile("MasterBeater69");
        Plan plan = user.getPlanList().get(0);
        for (int i = 0; i < plan.getExerciseList().size(); i++) {
            Exercise exercise = plan.getExerciseList().get(i);
            Set set = new Set("2018-01-15", exercise, plan);
            exercise.addSetToExercise(set);
            launchTest.fillTestSets(set);
            plan.getExerciseList().set(i, exercise);
        }
        user.getPlanList().set(0, plan);
        readTest.printLoadedProfileData(user);
    }
}
