package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Item {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String name;
	private String description;
	private float price;
	
	@ManyToOne
	@JoinColumn(name="gallery_id")
	private Gallery gallery;
	
	@OneToMany(mappedBy = "item", 
		 	cascade = CascadeType.ALL, orphanRemoval=true)
	private Set<Comment> comment = new HashSet<Comment>();
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Gallery getGallery() {
		return gallery;
	}
	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}
	public Set<Comment> getComments() {
		return comment;
	}
	public void setComments(Set<Comment> comment) {
		this.comment = comment;
	}
	public int getId() {
		return id;
	}
	
}
