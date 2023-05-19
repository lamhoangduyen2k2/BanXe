package vn.service.impl;

import java.util.List;

import vn.dao.ProductDAO;
import vn.dao.impl.ProductDaoImpl;
import vn.models.Product;
import vn.service.ProductService;



public class ProductServiceImpl implements ProductService{
	ProductDAO modelDao = new ProductDaoImpl();

	@Override
	public List<Product> findAllProduct() {
		return modelDao.findAllProduct();
	}
	public Product getTop1Product()
	{
		return modelDao.getTop1Product();
	}
	@Override
	public List<Product> findAllProductByCategoryId(String cid) {
		return modelDao.findAllProductByCategoryId(cid);
	}
	
	@Override
	public Product findProductByID(int _id) {
		return modelDao.findProductByID(_id);
	}

	@Override
	public void insert(Product product) {
		modelDao.insert(product);
	}

	@Override
	public void edit(Product product) {
		modelDao.edit(product);
	}
	
	@Override
	public void editQuantity(Product product) {
		modelDao.editQuantity(product);
	}

	@Override
	public void delete(int id) {
		modelDao.delete(id);
	}
	
	@Override
	public List<Product> Top5Seller() {
		return modelDao.Top5Seller();
	}
	
	@Override
	public double[] PercentOfTop() {
		return modelDao.PercentOfTop();
	}
	@Override
	public List<Product> modelService() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Product> searchbyName(String txtSearch)
	{
		return modelDao.searchbyName(txtSearch);
	}
	public int getTotalProduct()
	{
		return modelDao.getTotalProduct();
	}
	public List<Product> pagingProduct(int index,int indexP)
	{
		return modelDao.pagingProduct(index,indexP);
	}
	public int coutbyId(int cateId)
	{
		return modelDao.coutbyId(cateId);
	}
	public List<Product> pagingProductbyId(int cateId, int index,int size)
	{
		return modelDao.pagingProductbyId(cateId, index, size);
	}
	public List<Product> getTop5Product()
	{
		return modelDao.getTop5Product();
	}
}
