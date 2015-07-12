package sample;


import sample.scenes.MainScene;
import sample.scenes.nodes.MenuBarApp;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
	
		Group root;
		Stage stage;
		private void changeScene(Scene scene) {
			stage.setScene(scene);
		}
	
	
		
		
		
        @Override
        public void start(Stage stage) throws Exception {
            stage.setTitle("Just another ERP");
            
            stage.setMinHeight(700);
            stage.setMinWidth(600);
            this.stage = stage;
            MenuBarApp.setInstance(stage);
            Group root = new Group();
            stage.setScene(new MainScene(root,stage));
            stage.show();
        }

   
    public static void main(String[] args) {
            launch(args);
        }

}