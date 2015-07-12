package sample.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

public class Vehicule {
	StringProperty marque;
	StringProperty modele;
	StringProperty immatriculation;
	ObjectProperty<Color> color;
	IntegerProperty kilometrage;
	IntegerProperty annee;
	
	
	
	
	public Vehicule(String marque, String modele,
			String immatriculation, Color color,
			Integer kilometrage, Integer annee) {
		super();
		this.marqueProperty().set(marque);
		this.modelProperty().set(modele);
		this.immatriculationProperty().set(immatriculation);
		this.colorProperty().set(color);
		this.kilometrageProperty().set(kilometrage);
		this.anneeProperty().set(annee);
	}



	public StringProperty marqueProperty() {
		if(marque == null) {
			marque = new SimpleStringProperty(this, "marque");
		}
		return marque;
	}
	
	
	
	public StringProperty modelProperty() {
		if(modele == null) {
			modele= new SimpleStringProperty(this, "model");
		}
		return modele;
	}
	
	
	public StringProperty immatriculationProperty() {
		if(immatriculation == null) {
			immatriculation = new SimpleStringProperty(this, "immatriculation");
		}
		return immatriculation;
	}
	
	public ObjectProperty<Color> colorProperty() {
		if(color == null) {
			color = new SimpleObjectProperty<Color>(this, "color");
		}
		return color;
	}
	
	public IntegerProperty kilometrageProperty() {
		if(kilometrage == null) {
			kilometrage = new SimpleIntegerProperty(this, "kilometrage");
		}
		return kilometrage;
	}

	public IntegerProperty anneeProperty() {
		if(annee == null) {
			annee= new SimpleIntegerProperty(this, "annee");
		}
		return annee;
	}



	public String getMarque() {
		return marqueProperty().getValue();
	}



	public void setMarque(String marque) {
		this.marqueProperty().set(marque);
	}



	public String getModele() {
		return modelProperty().getValue();
	}



	public void setModele(String modele) {
		this.modelProperty().setValue(modele);
	}



	public String getImmatriculation() {
		return immatriculationProperty().getValue();
	}



	public void setImmatriculation(String immatriculation) {
		this.immatriculationProperty().setValue(immatriculation);
	}



	public Color getColor() {
		return colorProperty().getValue();
	}



	public void setColor(Color color) {
		this.colorProperty().setValue(color);
	}



	public void setKilometrage(Integer kilometrage) {
		this.kilometrageProperty().setValue(kilometrage);
	}



	public void setAnnee(Integer annee) {
		this.anneeProperty().setValue(annee);
	}
	
	
	public Integer getKilometrage() {
		return this.kilometrageProperty().get();
	}
	public Integer getAnnee() {
		return this.anneeProperty().get();
	}

	
	
	
	
	

}
