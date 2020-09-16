package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.models.tags.Tag;

@XmlRootElement(name = "Tableau")
@Entity
public class Tableau implements Serializable{

	public Long id;
	public String titre;
	public List<Fiche> fiches = new ArrayList<Fiche>();
	//private List<Tag> tags = new ArrayList<Tag>();

	public Tableau() {
		
	}
	
	public Tableau(String t) {
		this.titre = t;
		
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
	
	@XmlElement(name = "titre")
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	@JsonManagedReference
	@XmlElementWrapper(name = "fiches")
	@XmlElement(name = "fiche")
	@OneToMany(mappedBy = "tableau", cascade = CascadeType.PERSIST)
	public List<Fiche> getFiches() {
		return fiches;
	}
	public void setFiches(List<Fiche> fiches) {
		this.fiches = fiches;
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
        return "Tableau Kanban [id=" + id + ", titre=" + titre + ", nombre de fiches ="
                + fiches.size() + "]";
    }


}

