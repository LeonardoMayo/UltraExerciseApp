package test;

import Filewriting.*;
import PlanFramework.*;
import UserManagement.*;

import java.io.IOException;

public class ReadTest {

    ProfileToFile profileWriter = new ProfileToFile();
    PlansToFile planWriter = new PlansToFile();
    ExercisesToFile exerciseWriter = new ExercisesToFile();

    public ReadTest() {}

    public void init() throws IOException {
//        user = profileWriter.readProfile("MasterBeater69");
//        printLoadedProfileData();
//        ArrayList<Plan> plans;
//        ArrayList<Exercise> allExercises = new ArrayList<>();
//
//        for (int i = 0; i < user.getPlanList().size(); i++) {
//            Plan plan = planWriter.readPlan(user.getPlanList().get(i).getName());
//            user.getPlanList().set(i, plan);
//        }
//        plans = user.getPlanList();
//
//        for (int i = 0; i < plans.size(); i++) {
//            Plan plan = plans.get(i);
//            ArrayList<Exercise> exercises = plan.getExerciseList();
//            for (int j = 0; j < exercises.size(); j++) {
//                Exercise exercise = exerciseWriter.readExercise(exercises.get(j).getName());
//                user.getPlanList().get(i).getExerciseList().set(j, exercise);
//                allExercises.add(exercise);
//            }
//
//        }

        Profile user = profileWriter.readProfile("MasterBeater69");
        for (int i = 0; i < user.getPlanList().size() ; i++) {
            Plan plan = planWriter.readPlan(user.getPlanList().get(i).getName());
            for (int j = 0; j < plan.getExerciseList().size(); j++) {
                String name = plan.getExerciseList().get(j).getName();
                Exercise exercise = exerciseWriter.readExercise(name);
                plan.getExerciseList().set(j, exercise);
            }
            user.getPlanList().set(i, plan);
        }
    }

    public Profile loadCompleteProfile (String profileName) throws IOException{
        Profile user = profileWriter.readProfile(profileName);
        for (int i = 0; i < user.getPlanList().size() ; i++) {
            Plan plan = planWriter.readPlan(user.getPlanList().get(i).getName());
            for (int j = 0; j < plan.getExerciseList().size(); j++) {
                String name = plan.getExerciseList().get(j).getName();
                Exercise exercise = exerciseWriter.readExercise(name);
                plan.getExerciseList().set(j, exercise);
            }
            user.getPlanList().set(i, plan);
        }
        return user;
    }

    public void printLoadedProfileData(Profile user){

        System.out.println("--- "+user.getName()+" ---");
        System.out.println("Weight: "+user.getWeight()+", Height: "+user.getHeight()+";");
        System.out.println("Plans: "+user.getPlanList().size());
        for (int i = 0; i < user.getPlanList().size() ; i++) {
            Plan plan = user.getPlanList().get(i);
            System.out.println(plan.getName());
            System.out.println("Übungen: "+ plan.getExerciseList().size());
            for (int j = 0; j < plan.getExerciseList().size(); j++) {
                String nameExercise = plan.getExerciseList().get(j).getName();
                System.out.println(nameExercise);
                Exercise exercise = plan.getExerciseList().get(j);
                for (int k = 0; k < exercise.getSets().size(); k++) {
                    System.out.println(exercise.getSets().get(k).getDate()+": "+exercise.getSets().get(k).getRepeats());
                }
            }
        }
    }
}
