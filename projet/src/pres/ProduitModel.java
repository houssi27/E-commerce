package pres;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import metier.Produit;

public class ProduitModel extends AbstractTableModel{
	private String[] nomColonnes=new String[] {"REF","NOM","PRIX D'ACHAT","PRIX DE VENTE","QTE","IMG","CAT"};
	private Vector<String[]> rows=new Vector<String[]>();
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return nomColonnes.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rows.size();
	}
   @Override
public String getColumnName(int column) {
	// TODO Auto-generated method stub
	return nomColonnes[column];
}
	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return rows.get(arg0)[arg1];
	}
	public void loaddata(List<Produit> prods) {
		rows=new Vector<String[]>();
		for(Produit p:prods) {
			rows.add(new String[] {p.getRefProduit(),p.getNomProduit(),""+p.getPrix(),""+p.getPrix2(),""+p.getQuantite(),p.getImage(),p.getCategorie().getNomCat()});
		}
	fireTableChanged(null);
		
	}
}
