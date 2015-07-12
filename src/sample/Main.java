package sample;


import javafx.application.Application;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;

import javafx.stage.Stage;


public class Main extends Application {

        @Override
        public void start(Stage stage) throws Exception {
            stage.setTitle("Just another ERP");
            Group root = new Group();

            root.getChildren().add(createMenu(stage.widthProperty()));


            Scene scene = new Scene(root, 700, 600, Color.WHITE);
            stage.setMinHeight(700);
            stage.setMinWidth(600);

            stage.setScene(scene);
            stage.show();
        }

    private Node createMenu(ReadOnlyDoubleProperty readOnlyDoubleProperty) {
        MenuBar menu = FXUtil.build(new MenuBar(), menuBar -> {
            menuBar.getMenus().add(FXUtil.build(new Menu("Gestion administrative"), m->{
                m.getItems().add(FXUtil.build(new MenuItem("Ajouter un vehicule"), i->{
                    i.acceleratorProperty().set(KeyCombination.valueOf("Ctrl+N"));
                    i.setOnAction(e-> System.out.println("new item"));
                }));
                m.getItems().add(FXUtil.build(new Menu("Liste des vehicules"), i-> {
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
        menu.prefWidthProperty().bind(readOnlyDoubleProperty);
        return menu;
    }

    public static void main(String[] args) {
            launch(args);
        }

}