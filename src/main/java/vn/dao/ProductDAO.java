package vn.dao;

import java.util.List;

import vn.models.*;

public interface ProductDAO {
	List<Product> findAllProduct();
	List<Product> findAllProductByCategoryId(String cid);
	Product getTop1Product();
	Product findProductByID(int _id);
	void insert(Product product);
	void edit(Product product);
	void editQuantity(Product product);
	void delete(int id);
	List<Product> Top5Seller();
	double[] PercentOfTop();
	List<Product> searchbyName(String txtSearch);
	int getTotalProduct();
	List<Product> pagingProduct(int index,int indexP);
	int coutbyId(int cateId);
	List<Product> pagingProductbyId(int cateId, int index,int size);
	List<Product> getTop5Product();
}
