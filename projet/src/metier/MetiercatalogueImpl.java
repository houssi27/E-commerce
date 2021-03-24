package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetiercatalogueImpl implements IMetier {

	@Override
	/*public void addcategorie(Categorie c) {
		Connection conn=singletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					 ("insert into categories(nom_cat) values(?)");
			ps.setString(1,c.getNomCat());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/


	public void addProduit(Produit p, String Nomcat) {
		Connection conn=singletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					 ("insert into products(name,price,img,categorie) values(?,?,?,?)");
			
			ps.setString(1,p.getNomProduit());
			ps.setDouble(2, p.getPrix2());
			ps.setString(3,p.getImage());
			ps.setString(4, Nomcat);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void ModProduit(Produit p, String Nomcat) {
		Connection conn=singletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					 ("update products set  name=?,price=?,img=?,categorie=? where id=?");
			ps.setString(1,p.getNomProduit());
			ps.setDouble(2, p.getPrix2());
			ps.setString(3,p.getImage());
			ps.setString(4, Nomcat);
			ps.setString(5, p.getRefProduit());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	public void suppProduit(Produit p) {
		Connection conn=singletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					 ("delete from products  where ref_produit=?");
			ps.setString(1,p.getRefProduit());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Produit> getproduitsParMC(String mc) {
		List<Produit>prods=new ArrayList<>();
		
		Connection conn=singletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					
					 ("select * from products where name like ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Produit p=new Produit();
				
				p.setNomProduit(rs.getString("name"));
				
				p.setPrix2(rs.getDouble("price"));
				
				p.setImage(rs.getString("img"));
				String Nomcat=rs.getString("categorie");
				
					Categorie cat=new Categorie();
					
				
					cat.setNomCat(Nomcat);
					p.setCategorie(cat);
					
				
				prods.add(p);
			}
		    }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return prods;
	}




	



	
	/*@Override
	public List<Produit> getproduitsParCat(int idCat) {
		List<Produit>prods=new ArrayList<>();
		Connection conn=singletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					 ("select * from produits where id_cat like ?");
			ps.setInt(1,idCat);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Produit p=new Produit();
				p.setRefProduit(rs.getString("ref_produit"));
				p.setNomProduit(rs.getString("nom_produit"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
				
				
				PreparedStatement ps2=conn.prepareStatement
						 ("select * from categories where id_cat=?");
				ps2.setInt(1,idCat);
				ResultSet rs2=ps2.executeQuery();
				if(rs2.next()) {
					Categorie cat=new Categorie();
					cat.setIdCat(rs2.getInt("id_cat"));
					cat.setNomCat(rs2.getString("nom_cat"));
					p.setCategorie(cat);
					ps2.close();
				}
				prods.add(p);
			}
		    }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return prods;
	}*/

	@Override
	public List<String> gatAllcategorie() {
		List<String>catgs=new ArrayList<>();
		Connection conn=singletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					 ("select * from categories");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Categorie c=new Categorie();
				c.setIdCat(rs.getInt("id_cat"));
				c.setNomCat(rs.getString("nom_cat"));
				
				catgs.add(c.getNomCat());
				
				}
				ps.close();
			
		    }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return catgs;
	}
	
	




	

	/*@Override
	public Categorie getcategorie(int idCat) {
		Categorie c=null;
		Connection conn=singletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					 ("select * from categories where id_cat=?");
			ps.setInt(1, idCat);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				c=new Categorie();
				c.setIdCat(rs.getInt("id_cat"));
				c.setNomCat(rs.getString("nom_cat"));
				List<Produit>prods=this.getproduitsParCat(idCat);
				c.setProduits(prods);
				
				}
				ps.close();
			
		    }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return c;
	}*/
}
	


