package Desktop.controller;

import Filewriting.PlansToFile;
import PlanFramework.Plan;
import UserManagement.Profile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javafx.scene.layout.Pane;

/**
 * Created by Jan on 15.01.2018.
 */
public class FrameController extends Controller implements Initializable {

    public AnchorPane modulePane;
    public AnchorPane profilePane;
    public AnchorPane planPane;
    public Label date, name;
    public Button options;
    public AnchorPane planListPane;
    public ArrayList<AnchorPane> planTileList;
    public Button showAllPlansButton;
    public Button openPlanButton;
    public Label planNameLabel;
    public AnchorPane planTable;
    public Button backButton;


    private Map<String, Node> moduleMap;
    private Node firstModule = null;
    private Profile profile;
    public ArrayList<Plan> plans = new ArrayList<>();
    public Plan selectedPlan;

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
        planTileList = loadPlanTiles();
        plans = loadPlansfromProfile();

        for (int i = 0; i < plans.size(); i++) {
            List<Node> kids = planTileList.get(i).getChildren();
            for (int j = 0; j < kids.size(); j++) {
                Label label = (Label) kids.get(j);
                if (label.getId().contains("planNameLabel")) {
                    label.setText(plans.get(i).getName());
                } else if (label.getId().contains("lastUsedLabel")) {
                    ArrayList<String> dates = plans.get(i).getTrainingDates();
                    String preLastDate = dates.get(dates.size() - 1);
                    String lastDate = preLastDate.substring(preLastDate.length() - 2) + "/" + preLastDate.substring(5, 7) + "/" + preLastDate.substring(0, 3);
                    label.setText("Zuletzt gemacht am " + lastDate);
                }
            }
        }

        if (plans.size() < planTileList.size()) {
            int diff = planTileList.size() - plans.size();
            for (int i = 0; i < diff; i++) {
                AnchorPane pane = planTileList.get(planTileList.size() - i - 1);
                pane.setVisible(false);
            }

        }
        showAllPlansButton.setDisable(true);
        if (plans.size() > planTileList.size()) {
            showAllPlansButton.setDisable(false);
        }

    }

    private ArrayList<AnchorPane> loadPlanTiles() {
        ArrayList<AnchorPane> result = new ArrayList<>();
        List<Node> kids = planListPane.getChildren();
        for (int i = 0; i < kids.size(); i++) {
            result.add((AnchorPane) kids.get(i));
        }
        return result;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void openSelectedPlan(ActionEvent actionEvent) {
        profilePane.setVisible(false);
        planPane.setVisible(true);
    }

    public void setSelectedPlan(Event event) {

        String name = "";
        Pane source = (Pane) event.getSource();
        List<Node> kids = source.getChildren();
        for (int i = 0; i < kids.size(); i++) {
            Label label = (Label) kids.get(i);
            if (label.getId().contains("planName")) {
                name = label.getText();
            }
        }
        for (int i = 0; i < plans.size(); i++) {
            if (plans.get(i).getName().equals(name)) {
                selectedPlan = plans.get(i);
            }
        }
        for (int i = 0; i < planTileList.size(); i++) {
            planTileList.get(i).setStyle("-fx-background-color: #f3f3f3");
        }
        source.setStyle("-fx-background-color: #d6d6d6;");
        openPlanButton.setDisable(false);

    }
}
