package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.v3.oas.models.tags.Tag;

@XmlRootElement(name = "Utilisateur")
@Entity
public class Utilisateur implements Serializable{

	public Long id;
	public String nom;
	public String prenom;
	public String fonction;
	//private List<Tag> tags = new ArrayList<Tag>();
public Utilisateur() {
		
	}

public Utilisateur(String nom, String prenom, String fonc) {
	this.nom= nom;
	this.prenom = prenom;
	this.fonction = fonc;
	
}

@XmlElement(name = "id")
@Id
@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name = "nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@XmlElement(name = "prenom")
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@XmlElement(name = "fonction")
	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
//	@XmlElementWrapper(name = "tags")
//	  @XmlElement(name = "tag")
//	  public List<Tag> getTags() {
//	    return tags;
//	  }
//
//	  public void setTags(List<Tag> tags) {
//	    this.tags = tags;
//	  }

	@Override
    public String toString() {
        return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom="
                + prenom + "]";
    }

	
}
