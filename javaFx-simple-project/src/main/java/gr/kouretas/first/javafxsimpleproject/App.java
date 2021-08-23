package gr.kouretas.first.javafxsimpleproject;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class App extends javafx.application.Application implements EventHandler<MouseEvent> {
    // Stage
    Stage primaryStage;
    // Scene
    Scene mainScene;
    /////////////////////
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


    private void initialize_fields() {
        cl_list = new ArrayList<>();
        rootGridPane = new GridPane();
        buttonFlowPane = new FlowPane();
        nameLbl = new Label("Όνομα: ");
        priceLbl = new Label("Ποσο: ");
        nameField = new TextField();
        priceField = new TextField();
        newClBtn = new Button("Νέος Πελάτης");
        updateClBtn = new Button("Ενημέρωση");
        deleteClBtn = new Button("Διαγραφή");
        inputFieldsPane = new GridPane();
        ClTableView = new TableView<>();
    }

    private void customize_flowPane() {
        ///TODO put some gap in the bottom of the flowPane
        buttonFlowPane.setHgap(10);
        buttonFlowPane.getChildren().add(newClBtn);
        buttonFlowPane.getChildren().add(updateClBtn);
        buttonFlowPane.getChildren().add(deleteClBtn);
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
    }

    private void customize_gridPane() {
        inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
        inputFieldsPane.setVgap(10);
        inputFieldsPane.setHgap(10);
        inputFieldsPane.add(nameLbl, 0, 0);
        inputFieldsPane.add(nameField, 1, 0);
        inputFieldsPane.add(priceLbl, 0, 1);
        inputFieldsPane.add(priceField, 1, 1);
    }

    private void customize_rootScene() {
        rootGridPane.setVgap(10);
        rootGridPane.setHgap(10);
        rootGridPane.add(inputFieldsPane, 1, 0);
        rootGridPane.add(ClTableView, 0, 0);
        rootGridPane.add(buttonFlowPane, 0, 1);
    }

    private void customize_tableView() {
        TableColumn<Client, String> nameColumn = new TableColumn<>("Όνομα");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        ClTableView.getColumns().add(nameColumn);

        TableColumn<Client, String> priceColumn = new TableColumn<>("Συνολικό Ποσό");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        ClTableView.getColumns().add(priceColumn);
    }

    private void buttons_attach_event() {
        newClBtn.setOnMouseClicked(this);
        updateClBtn.setOnMouseClicked(this);
        deleteClBtn.setOnMouseClicked(this);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Οφειλές Πελατών");
        initialize_fields();
        customize_flowPane();
        customize_gridPane();
        customize_rootScene();
        customize_tableView();
        buttons_attach_event();


        mainScene = new Scene(rootGridPane, 650, 300);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == newClBtn) {
            String name = nameField.getText();
            double price = 12.5;
            createClient(name, price);


            tableSync();
            clearTextFields();

        }
    }

    private void clearTextFields() {
        nameField.setText("");
        priceField.setText("");
    }

    private void tableSync() {
        List<Client> items = ClTableView.getItems();
        items.clear();
    }

    private void createClient(String name, double price) {
        Client new_client = new Client(name, price);
        cl_list.add(new_client);
    }
}