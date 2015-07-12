package sample.scenes.nodes;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import sample.FXUtil;

public class MenuBarApp  { 
	private static MenuBarApp menu;
	private Stage stage;
	public MenuBarApp(Stage stage) {
		this.stage = stage;
	}
	
	public static void setInstance(Stage stage) {
		menu = new MenuBarApp(stage);
	}
	
	public static MenuBarApp getInstance() {

		return menu;
	}
	
	 public Node createMenu(ReadOnlyDoubleProperty readOnlyDoubleProperty) {

	        System.out.println("menubar constructing");
	        MenuBar menu = FXUtil.build(new MenuBar(), menuBar -> {
	            menuBar.getMenus().add(FXUtil.build(new Menu("Gestion administrative"), m->{
	                m.getItems().add(FXUtil.build(new MenuItem("Ajouter un vehicule"), i->{
	                    i.acceleratorProperty().set(KeyCombination.valueOf("Ctrl+N"));
	                    i.setOnAction(e-> {
	                    	 //stage.setScene(new NewVehicule(new Group(), stage));
	                    	 System.out.println("new item");
	                    });
	                   
	            
	                    
	                }));
	                m.getItems().add(FXUtil.build(new MenuItem("Liste des vehicules"), i-> {
	                    i.acceleratorProperty().set(KeyCombination.valueOf("Ctrl+A"));
	                    i.setOnAction(e-> System.out.println("Liste des vehicules"));
	                }));
	            }));
	            menuBar.getMenus().add(FXUtil.build(new Menu("Gestion des stocks"), m -> {

	            }));
	            menuBar.getMenus().add(FXUtil.build(new Menu("Gestion technique"), m -> {

	            }));
	            menuBar.getMenus().add(FXUtil.build(new Menu("Gestion factures"), m -> {

	            }));
	        });
	        System.out.println("menubar constructed");
	        menu.prefWidthProperty().bind(readOnlyDoubleProperty);
	        return menu;
	    }

}
