import daoCategories.DaoCategorieImpl;
import daoProduits.DaoProduitImpl;

public class Test {
	public static void main(String[] args) {
		Connexion conn = null;
		DaoCategorieImpl daocategorieimpl = new DaoCategorieImpl();
		DaoProduitImpl daoproduitimpl = new DaoProduitImpl();
		System.out.println(conn.getConnection());
	}

}
