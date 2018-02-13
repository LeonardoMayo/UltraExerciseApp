package Desktop.controller;

import Filewriting.PlansToFile;
import PlanFramework.Plan;
import UserManagement.Profile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Jan on 15.01.2018.
 */
public class FrameController extends Controller implements Initializable {

    public AnchorPane modulePane;
    public AnchorPane profilePane;
    public AnchorPane planPane;
    public Label date, name;
    public Button options;
    public ListView<String> planList;

    private Map<String, Node> moduleMap;
    private Node firstModule = null;
    private Profile profile;
    public ArrayList<Plan> plans = new ArrayList<>();

    public FrameController() {
        System.out.println("FrameController created");
        moduleMap = new HashMap<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void startUp() {

        name.setText(profile.getName());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        date.setText(dateFormat.format(currentDate));

        try {
            fillPlanlist();
        } catch (IOException e) {
            e.printStackTrace();
        }

        planPane.setVisible(false);
        profilePane.setVisible(true);

    }

    public void addModule(String name, Node content) {

        moduleMap.put(name, content);

        if (firstModule == null) {
            firstModule = content;
        }
    }

    public void fillPlanlist() throws IOException {
        plans = loadPlansfromProfile();
        ObservableList<String> items = FXCollections.observableArrayList();
        for (int i = 0; i < plans.size(); i++) {
            items.add(plans.get(i).getName());
        }
        planList.setItems(items);
    }

    public ArrayList<Plan> loadPlansfromProfile() {
        ArrayList<Plan> result = new ArrayList<>();
        PlansToFile plansToFile = new PlansToFile();
        plansToFile.setCurrentUser(profile);
        ArrayList<Plan> loadedFromUser = profile.getPlanList();
        for (int i = 0; i < loadedFromUser.size(); i++) {
            Plan plan = null;
            boolean doesExist = true;

            plan = plansToFile.readPlan(loadedFromUser.get(i).getName());
            if (plan == null) {
                doesExist = false;
                System.out.println("Error - File " + loadedFromUser.get(i).getName() + " was not found or does not exist!");
            } else {
                result.add(plan);
            }

        }
        profile.setPlanList(result);
        return result;
    }

    public void loadProfileModule() {

    }


    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void openSelectedPlan(ActionEvent actionEvent) {

    }
}
