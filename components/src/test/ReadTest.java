package test;

import Filewriting.*;
import PlanFramework.*;
import UserManagement.*;

import java.io.IOException;
import java.util.ArrayList;

public class ReadTest {

    ProfileToFile profileWriter = new ProfileToFile();
    PlansToFile planWriter = new PlansToFile();
    ExercisesToFile exerciseWriter = new ExercisesToFile();
    Profile user;

    public ReadTest() {
    }

    public void init() throws IOException {
        user = profileWriter.readProfile("MasterBeater69");
        printLoadedProfileData();
        ArrayList<Plan> plans;
        ArrayList<Exercise> allExercises;

        for (int i = 0; i < user.getPlanList().size(); i++) {
            Plan plan = planWriter.readPlan(user.getPlanList().get(i).getName());
            user.getPlanList().set(i, plan);
        }
        plans = user.getPlanList();

        for (int i = 0; i < plans.size(); i++) {

        }
    }

    public void printLoadedProfileData(){

        System.out.println("--- Print out loaded Data from "+user.getName()+" ---");
        System.out.println("weight: "+user.getWeight()+", height: "+user.getHeight()+";");
        System.out.println("Plans: "+user.getPlanList().size());
        for (int i = 0; i < user.getPlanList().size(); i++) {
            System.out.println(user.getPlanList().get(i).getName());
        }

    }
}
