package Desktop.controller;

import Filewriting.ProfileToFile;

import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.ArrayList;

import Desktop.Start;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import UserManagement.Profile;

/**
 * Created by Jan on 16.01.2018.
 */


public class RootController extends Controller implements Initializable {

    @FXML
    public AnchorPane loginPane;
    public AnchorPane registrationPane;
    public AnchorPane modulePane;
    public Button loginButton;
    public Button goToRegister;
    public ListView profileList;

    public TextField registrationNameField;
    public TextField registrationHeightField;
    public TextField registrationWeightField;
    public Button registrationButton;
    public AnchorPane profilePlace1;
    public AnchorPane profilePlace2;
    public AnchorPane profilePlace3;

    public ArrayList<AnchorPane> profilePlaces;
    public ArrayList<Profile> profiles;
    public Profile selectedProfile;
    private Map<String, Node> moduleMap;
    private Node firstModule = null;
    public Start startInstance;

    private String dir = System.getProperty("user.dir") + "\\saveddata\\";

    public RootController() {
        System.out.println("RootController created");
        moduleMap = new HashMap<>();
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

        loginPane.setVisible(true);
        try {
            profiles = loadProfiles(dir + "profiles");
        } catch (IOException e) {
            e.printStackTrace();
        }
        profilePlaces = new ArrayList<>();
        fillProfileList();
    }

    public void fillProfileList() {
        //ArrayList<Profile> profiles = loadProfiles(dir + "profiles");
        profilePlaces.add(profilePlace1);
        profilePlaces.add(profilePlace2);
        profilePlaces.add(profilePlace3);
        for (int i = 0; i < profiles.size(); i++) {
            AnchorPane pane = profilePlaces.get(i);
            List<Node> kids = pane.getChildren();
            int nameSize = profiles.get(i).getName().length() - 5;
            profiles.get(i).setName(profiles.get(i).getName().substring(0, nameSize));
            Profile current = profiles.get(i);
            for (int j = 0; j < kids.size(); j++) {
                Label label = (Label) kids.get(j);
                if (label.getId().contains("name")) {
                    label.setText(current.getName());
                } else if (label.getId().contains("weight")) {
                    label.setText(String.valueOf(current.getWeight()) + " kg");
                } else if (label.getId().contains("height")) {
                    label.setText(String.valueOf(current.getHeight()) + " cm");
                }
            }
        }

        if (profiles.size() < profilePlaces.size()) {
            int diff = profilePlaces.size() - profiles.size();
            if (diff == 2) {
                profilePlaces.get(profilePlaces.size() - diff).setVisible(false);
                profilePlaces.get(profilePlaces.size() - diff + 1).setVisible(false);
            } else if (diff == 1) {
                profilePlaces.get(profilePlaces.size() - diff).setVisible(false);
            }
        }
    }

    public void addModule(String name, Node content) {

        moduleMap.put(name, content);
        if (firstModule == null) {
            firstModule = content;
        }
    }


    public void changeToLogin() {
        registrationPane.setVisible(false);
        loginPane.setVisible(true);
    }

    public void changeToRegistration() {

        loginPane.setVisible(false);
        registrationPane.setVisible(true);

    }

    public void changeToFrameModule() throws Exception {

        startInstance.setSelectedProfile("null");
        modulePane.setVisible(false);
        startInstance.loadFrame(selectedProfile);
    }

    public ArrayList<Profile> loadProfiles(String path) throws IOException {
        ProfileToFile profileToFile = new ProfileToFile();
        ArrayList<String> names = profileToFile.getFileNamesAndCount("profiles");
        ArrayList<Profile> result = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            result.add(profileToFile.readProfile(names.get(i)));
        }
        return result;
    }

    public void setSelectedProfile(MouseEvent mouseEvent) {
        String name = "";
        Pane source = (Pane) mouseEvent.getSource();
        List<Node> kids = source.getChildren();
        for (int i = 0; i < kids.size(); i++) {
            Label label = (Label) kids.get(i);
            if (label.getId().contains("name")) {
                name = label.getText();
            }
        }
        for (int i = 0; i < profiles.size(); i++) {
            if (profiles.get(i).getName().equals(name)){
                selectedProfile = profiles.get(i);

            } else if (name.equals("")){
                System.out.println("INFO - Loaded Profile "+name+", proceed to Frame.");
            }
        }
        for (int i = 0; i < profilePlaces.size(); i++) {
            profilePlaces.get(i).setStyle("-fx-background-color: #f3f3f3");
        }
        source.setStyle("-fx-background-color: #d6d6d6;");
        loginButton.setDisable(false);
    }
}
