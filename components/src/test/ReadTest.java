package test;

import Filewriting.*;
import PlanFramework.*;
import UserManagement.*;

import java.io.IOException;
import java.util.ArrayList;

public class ReadTest {

    WriteProfileToFile profileWriter = new WriteProfileToFile();
    WritePlansToFile planWriter = new WritePlansToFile();
    WriteExercisesToFile exerciseWriter = new WriteExercisesToFile();
    Profile user;

    public ReadTest() {
    }

    public void init() throws IOException {
        user = profileWriter.readProfile("MasterBeater69");
        printLoadedData();
    }

    public void printLoadedData(){

        System.out.println("--- Print out loaded Data from "+user.getName()+" ---");
        System.out.println("weight: "+user.getWeight()+", height: "+user.getHeight()+";");
        System.out.println("Plans: "+user.getPlanList().size());
        for (int i = 0; i < user.getPlanList().size(); i++) {
            System.out.println(user.getPlanList().get(i).getName());
        }

    }
}
