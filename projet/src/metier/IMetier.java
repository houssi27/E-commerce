package metier;

import java.util.List;

public interface IMetier {
	//public void addcategorie(Categorie c);
	public void addProduit(Produit p,String Nomcat);
	public void suppProduit(Produit p);
	public void ModProduit(Produit p,String Nomcat);
	public List<Produit> getproduitsParMC(String mc);
	//public List<Produit> getproduits();
	//public List<Produit> getproduitsParCat(int idCat);
	public List<String> gatAllcategorie();
	//public Categorie getcategorie (int idCat);
		
	
		
	
}
