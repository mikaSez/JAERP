package sample.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Person {

    private StringProperty email;
    private StringProperty lastName;
    private ObservableList<Vehicule> vehicules = FXCollections.observableArrayList();
    
    
    public String nbVehicules() {
    	return vehicules.size() + " vehicules";
    }
    
    public final void setEmail(String value) {
        emailProperty().set(value);
}
    public final String getEmail() {
        return emailProperty().get();
}
    public StringProperty emailProperty() {
        if (email == null) {
            email = new SimpleStringProperty();
        }
        return email;
    }

    public final void setLastName(String value) {
        lastNameProperty().set(value);
}
    public final String getLastName() {
        return lastNameProperty().get();
}
    public StringProperty lastNameProperty() {
        if (lastName == null) {
            lastName = new SimpleStringProperty();
        }
        return lastName;
    }
    public ObservableList<Vehicule> vehiculesProperty() {
        return vehicules;
}
    public Person(String email, String lastName) {
        setEmail(email);
        setLastName(lastName);
} 
    }

