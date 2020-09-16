package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.models.tags.Tag;

@XmlRootElement(name = "Fiche")
@Entity
public class Fiche implements Serializable{

//	Un libellé
//	La date butoire
//	un utilisateur à qui cette tâche est affectée
//	Le temps dont vous estimez avoir besoin en minutes
//	un ensemble de tags
//	un lieu
//	une url
//	il est également possible d'ajouter une note explicative.

	public Long id;
	public Tableau tableau;
	public String libelle;
	public Date date;
	public Utilisateur utilisateur;
	public int temps;
	public String lieu;
	public String url;
	public String note;
	public Etat etat;
	//private List<Tag> tags = new ArrayList<Tag>();
	public Fiche() {
		
	}
	
	
	public Fiche(String l, Date d, Utilisateur u, int t, String lieu, String url, String n, Etat e, Tableau tab) {

		this.tableau = tab;
		this.libelle = l;
		this.date = d;
		this.utilisateur = u;
		this.temps = t;
		this.lieu = l;
		this.url = url;
		this.note = n;
		this.etat = e;
		
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
	@JsonBackReference
	@XmlElement(name = "tableau")
	@ManyToOne
	public Tableau getTableau() {
		return tableau;
	}

	public void setTableau(Tableau tableau) {
		this.tableau = tableau;
	}
	
	@XmlElement(name = "libelle")
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@XmlElement(name = "date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@XmlElement(name = "utilisateur")
	@OneToOne
	@JoinColumn(referencedColumnName = "id")
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	@XmlElement(name = "temps")
	public int getTemps() {
		return temps;
	}
	public void setTemps(int temps) {
		this.temps = temps;
	}
	
	@XmlElement(name = "lieu")
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
	@XmlElement(name = "url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@XmlElement(name = "note")
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@XmlElement(name = "etat")
	@Enumerated(EnumType.STRING)
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
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
        return "Fiche [id=" + id + ", libellé=" + libelle + ", date butoire="
                + date +", utilisateur=" + utilisateur.getPrenom() + ", temps" +
                temps +", lieu" + lieu + ", url" + url + ", note" + note +", etat" + etat
                +"]";
    }

	
}
