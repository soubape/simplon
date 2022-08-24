package daoProduits;

import java.util.List;

import entites.Produits;

public interface DaoProduit {
	
	public void addProduit();
	public void updateProduit(int id);
	public void deleteProduit(int id);
	public Produits findByIdProduit(int id);
	public List<Produits> getAllProduit();

}
