package gr.kouretas.first.javafxsimpleproject;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class ClientSceneCreator extends SceneCreator {
    // List of Clients
    ArrayList<Client> cl_list;
    // Flow Pane
    FlowPane buttonFlowPane;
    // Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    // Buttons
    Button newClBtn, updateClBtn, deleteClBtn;
    // Labels
    Label nameLbl, priceLbl;
    // Textfields
    TextField nameField, priceField;
    // TableView
    TableView<Client> ClTableView;

    public ClientSceneCreator(double width, double height) {
        super(width, height);
        initialize_fields();
        customize_flowPane();
        customize_rootScene();
    }

    private void customize_rootScene() {
        rootGridPane.setVgap(10);
        rootGridPane.setHgap(10);
        rootGridPane.add(inputFieldsPane, 1, 0);
        rootGridPane.add(ClTableView, 0, 0);
        rootGridPane.add(buttonFlowPane, 0, 1);
    }

    private void customize_flowPane() {
        buttonFlowPane.setHgap(10);
        buttonFlowPane.getChildren().add(newClBtn);
        buttonFlowPane.getChildren().add(updateClBtn);
        buttonFlowPane.getChildren().add(deleteClBtn);
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
    }

    private void initialize_fields() {
        cl_list = new ArrayList<>();
        rootGridPane = new GridPane();
        buttonFlowPane = new FlowPane();
        nameLbl = new Label();
        priceLbl = new Label();
        nameField = new TextField();
        priceField = new TextField();
        newClBtn = new Button();
        updateClBtn = new Button();
        deleteClBtn = new Button();
        inputFieldsPane = new GridPane();
        ClTableView = new TableView<>();
    }

    @Override
    Scene createScene() {
        return new Scene(rootGridPane, width, height);
    }
}
