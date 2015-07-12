package sample.scenes;

import sample.models.Person;
import sample.models.Vehicule;
import sample.scenes.nodes.MenuBarApp;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.models.Vehicule;


public class MainScene extends Scene {
	FlowPane box = new FlowPane();

	
	@SuppressWarnings("unchecked")
	public MainScene(Group root, Stage stage) {	
		super(root, 800, 600, Color.WHITE);

		MenuBarApp menu = new MenuBarApp(stage);
        root.getChildren().add(menu.createMenu(stage.widthProperty()));

        GridPane gridpane = new GridPane();
        gridpane.setLayoutY(30);
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(10);

        Label candidatesLbl = new Label("Propriétaires");
        GridPane.setHalignment(candidatesLbl, HPos.CENTER);
        gridpane.add(candidatesLbl, 0, 0);

        ObservableList<Person> proprietaires = getPeople();
        final ListView<Person> ownerListView = new ListView<>(proprietaires);
        ownerListView.setPrefWidth(200);
        ownerListView.setPrefHeight(150);

        ownerListView.setCellFactory(new Callback<ListView<Person>, ListCell<Person>>() {
            public ListCell<Person> call(ListView<Person> param) {
                final Label leadLbl = new Label();
                final Tooltip tooltip = new Tooltip();
                    final ListCell<Person> cell = new ListCell<Person>() {
                        @Override
                        public void updateItem(Person item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    leadLbl.setText(item.getEmail());
                                    setText(item.getLastName());
                                    tooltip.setText(item.nbVehicules());
                                    setTooltip(tooltip);
        } }
                    }; 
                    return cell;
            }
        }); // setCellFactory
        gridpane.add(ownerListView, 0, 1);
        Label emplLbl = new Label("Vehicules");
        gridpane.add(emplLbl, 2, 0);
        GridPane.setHalignment(emplLbl, HPos.CENTER);
        final TableView<Vehicule> vehiculesTableView = new TableView<>();
        vehiculesTableView.setPrefWidth(550);
        final ObservableList<Vehicule> ownedVehicules = FXCollections.observableArrayList();
        vehiculesTableView.setItems(ownedVehicules);
        
        TableColumn<Vehicule, String> marqueCol = new TableColumn<>("Marque");
        marqueCol.setEditable(true);
        marqueCol.setCellValueFactory(new PropertyValueFactory<>("Marque"));
        marqueCol.setPrefWidth(vehiculesTableView.getPrefWidth() / 6);
        
        TableColumn<Vehicule, String> modelCol = new TableColumn<>("Modele");
        modelCol.setCellValueFactory(new PropertyValueFactory<>("modele"));
        modelCol.setPrefWidth(vehiculesTableView.getPrefWidth() / 6);
        
        TableColumn<Vehicule, Color> colorCol = new TableColumn<>("Couleur");
        colorCol.setCellValueFactory(new PropertyValueFactory<>("Color"));
        colorCol.setPrefWidth(vehiculesTableView.getPrefWidth() / 6);
        

        TableColumn<Vehicule, String> immatriculationCol = new TableColumn<>("Immatriculation");
        immatriculationCol.setCellValueFactory(new PropertyValueFactory<>("immatriculation"));
        immatriculationCol.setPrefWidth(vehiculesTableView.getPrefWidth() / 6);

        TableColumn<Vehicule, Integer> kilometrageCol = new TableColumn<>("Kilometrage");
        kilometrageCol.setCellValueFactory(new PropertyValueFactory<>("kilometrage"));
        kilometrageCol.setPrefWidth(vehiculesTableView.getPrefWidth() / 6);

        TableColumn<Vehicule, Integer> yearCol = new TableColumn<>("Année");
        yearCol.setCellValueFactory(new PropertyValueFactory<>("annee"));
        yearCol.setPrefWidth(vehiculesTableView.getPrefWidth() / 6);
        
        
        
        vehiculesTableView.getColumns().setAll(marqueCol, modelCol, colorCol, immatriculationCol, kilometrageCol, yearCol);
        gridpane.add(vehiculesTableView, 2, 1);
        // selection listening
        ownerListView.getSelectionModel().selectedItemProperty().addListener(new
        ChangeListener<Person>() {
                    public void changed(ObservableValue<? extends Person> observable, Person oldValue,
        Person newValue) {
                        if (observable != null && observable.getValue() != null) {
                            ownedVehicules.clear();
                            ownedVehicules.addAll(observable.getValue().vehiculesProperty());
        } }
                });
                root.getChildren().add(gridpane);


        
        root.getChildren().add(box);
        System.out.println("Main show");
	}
	 private ObservableList<Person> getPeople() {
	        ObservableList<Person> people = FXCollections.<Person>observableArrayList();
	        Person docX = new Person("Professor@XavierSchool.com", "Charles");
	        docX.vehiculesProperty().add(new Vehicule("Volvo","XC60", "AA234CD", Color.AQUA, 23423, 2001 ));
	        docX.vehiculesProperty().add(new Vehicule("Volvo", "V40", "AA111SS", Color.WHEAT, 1000, 2012));
	        docX.vehiculesProperty().add(new Vehicule("Mercedes", "E-GUARD", "SDF324D", Color.BLACK, 12333, 2014));
	        Person magneto = new Person("Magneto@Vilains.fr", "Max");
	        magneto.vehiculesProperty().add(new Vehicule("Mercedes", "M-GUARD", "SS123DS", Color.WHITE, 222, 2015));
	        magneto.vehiculesProperty().add(new Vehicule("Mercedes", "M-GUARD", "DS453SF", Color.BLACK, 234,2015));
	        magneto.vehiculesProperty().add(new Vehicule("Porshe", "911 Carrera", "SD123SA", Color.BLACK, 12313, 2012));
	        Person biker = new Person("Mountain@Tripoli.en", "Gennick");
	        biker.vehiculesProperty().add(new Vehicule("Yamaha", "R1M", "DF453S", Color.BLACK, 4522,2011));
	        biker.vehiculesProperty().add(new Vehicule("Yamaha", "YZF-R1", "FZ234S", Color.RED, 234,2012));
	        biker.vehiculesProperty().add(new Vehicule("Yamaha", "TZR50", "FE234SC", Color.BEIGE, 34, 2010));
	        biker.vehiculesProperty().add(new Vehicule("Triumph", "Street triple 675","DR342D" ,Color.BLACK, 22500, 2007));
	        biker.vehiculesProperty().add(new Vehicule("Triumph", "Bonneville 865", "TF123dd", Color.AZURE,74000, 2002));
	        biker.vehiculesProperty().add(new Vehicule("Suzuki", "GSX-R 600", "FDD234D", Color.BLUE, 20500, 2010));
	        people.add(docX);
	        people.add(magneto);
	        people.add(biker);
	        return people;
	 }
	
}



