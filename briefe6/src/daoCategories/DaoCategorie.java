package daoCategories;

import java.sql.Connection;
import java.util.List;

import entites.Categories;
import entites.Produits;

public interface DaoCategorie {
	public static final Connection connexion = null;
	public void addCategorie();
	public void updateCategorie(int id);
	public void deleteCategorie(int id);
	public List<Produits> findByIdCategorie(int id);
	public List<Categories> getAllCategorie();

}
