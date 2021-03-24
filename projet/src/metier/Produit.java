package metier;

import java.io.Serializable;

public class Produit implements Serializable{
	private String refProduit;
	private String nomProduit;
	private double prix;
	private double prix2;
		private int quantite;
	private String image;
	private Categorie categorie;
	
	
	


	
	
	
	
	public Produit(String refProduit, String nomProduit, double prix,double prix2, int quantite, String image, Categorie categorie) {
		super();
		this.refProduit = refProduit;
		this.nomProduit = nomProduit;
		this.prix = prix;
		this.prix2 = prix2;
		this.quantite = quantite;
		this.image = image;
		this.categorie = categorie;
		
	}

	public double getPrix2() {
		return prix2;
	}



	public void setPrix2(double prix2) {
		this.prix2 = prix2;
	}


	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public String getRefProduit() {
		return refProduit;
	}
	public void setRefProduit(String refProduit) {
		this.refProduit = refProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
}
