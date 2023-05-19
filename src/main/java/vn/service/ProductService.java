package vn.service;

import java.util.List;

import vn.models.*;

public interface ProductService {
	List<Product> findAllProduct();
	List<Product> findAllProductByCategoryId(String cid);
	Product findProductByID(int _id);
	void insert(Product product);
	void edit(Product product);
	void editQuantity(Product product);
	void delete(int id);
	List<Product> Top5Seller();
	List<Product> modelService();
	double[] PercentOfTop();
	Product getTop1Product();
	List<Product> searchbyName(String txtSearch);
	int getTotalProduct();
	List<Product> pagingProduct(int index, int indexP);
	int coutbyId(int cateId);
	List<Product> pagingProductbyId(int cateId, int index,int size);
	List<Product> getTop5Product();
}
