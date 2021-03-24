package metier;

import java.util.List;

public class test {

	public static void main(String[] args) {
		MetiercatalogueImpl metier=new MetiercatalogueImpl();
		
		//metier.addcategorie(new Categorie("impremante"));
      /*  metier.addProduit(new Produit("p2","HP 89",65000,33), 1);
        metier.addProduit(new Produit("p3","Imp",40000,33), 3);
        metier.addProduit(new Produit("p4","aze",40000,33), 3);*/
		List<Produit>prods=metier.getproduitsParMC("p");
		for(Produit c:prods) {
			System.out.println(c.getCategorie().getIdCat());
		}
       
	}

}
