package metier;

import java.io.Serializable;
import java.util.*;

public class Categorie implements Serializable {
	private int idCat;
	private String nomCat;
	private List<Produit> produits=new ArrayList<>();
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Categorie(String nomCat) {
		super();
		this.nomCat = nomCat;
	}
	
	public int getIdCat() {
		return idCat;
	}
	
	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}
	public String getNomCat() {
		return nomCat;
	}
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
}
