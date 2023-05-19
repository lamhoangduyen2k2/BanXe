package vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.connection.ConnectJDBC;
import vn.dao.*;
import vn.models.*;
import vn.service.*;
import vn.service.impl.*;

public class ProductDaoImpl extends ConnectJDBC implements ProductDAO{
	StoreService storeService = new StoreServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();
	
	@Override
	public List<Product> findAllProduct() {
		List<Product> productList = new ArrayList<Product>();
		String sql = "Select * from Product";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.set_id(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setSelling(rs.getBoolean("isSelling"));
				product.setDeleted(rs.getBoolean("isDeleted"));
				product.setRating(rs.getInt("rating"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setCreatedAt(rs.getDate("createdAt"));
				product.setUpdatedAt(rs.getDate("updatedAt"));
				if(rs.getInt("categoryId") != 0)
				{
					Category cate = cateService.findCategoryByID(rs.getInt("categoryId"));
					product.setCategory(cate);
				}
				if(rs.getInt("storeId") != 0)
				{
					Store store = storeService.findStoreByID(rs.getInt("storeId"));
					product.setStore(store);
				}
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}
	
	@Override
	public List<Product> findAllProductByCategoryId(String cid) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "select * from Product\r\n"
				+ "where categoryId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.set_id(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setSelling(rs.getBoolean("isSelling"));
				product.setDeleted(rs.getBoolean("isDeleted"));
				product.setRating(rs.getInt("rating"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setCreatedAt(rs.getDate("createdAt"));
				product.setUpdatedAt(rs.getDate("updatedAt"));
				if(rs.getInt("categoryId") != 0)
				{
					Category cate = cateService.findCategoryByID(rs.getInt("categoryId"));
					product.setCategory(cate);
				}
				if(rs.getInt("storeId") != 0)
				{
					Store store = storeService.findStoreByID(rs.getInt("storeId"));
					product.setStore(store);
				}
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}
	
	@Override
	public Product findProductByID(int _id) {
		String sql = "Select * From Product where _id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, _id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				Product product = new Product();
				product.set_id(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setSelling(rs.getBoolean("isSelling"));
				product.setDeleted(rs.getBoolean("isDeleted"));
				product.setRating(rs.getInt("rating"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setCreatedAt(rs.getDate("createdAt"));
				product.setUpdatedAt(rs.getDate("updatedAt"));
				if(rs.getInt("categoryId") != 0)
				{
					Category cate = cateService.findCategoryByID(rs.getInt("categoryId"));
					product.setCategory(cate);
				}
				if(rs.getInt("storeId") != 0)
				{
					Store store = storeService.findStoreByID(rs.getInt("storeId"));
					product.setStore(store);
				}
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void insert(Product product)
	{
		String sql = "INSERT INTO dbo.Product\r\n"
				+ "(\r\n"
				+ "    name,\r\n"
				+ "    description,\r\n"
				+ "    price,\r\n"
				+ "    promotionalPrice,\r\n"
				+ "    quantity,\r\n"
				+ "    categoryId,\r\n"
				+ "    storeId\r\n"
				+ ")\r\n"
				+ "VALUES\r\n"
				+ "(   ?,     -- name\r\n"
				+ "    ?,    -- description\r\n"
				+ "    ?, -- price\r\n"
				+ "    ?, -- promotionalPrice\r\n"
				+ "    ?,    -- quantity\r\n"
				+ "    ?, -- categoryId\r\n"
				+ "    ? -- storeId\r\n"
				+ "    )";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, product.getName());
		ps.setString(2, product.getDescription());
		ps.setDouble(3, product.getPrice());
		ps.setDouble(4, product.getPromotionalPrice());
		ps.setInt(5, product.getQuantity());
		ps.setInt(6, product.getCategoryId());
		ps.setInt(7, product.getStoreId());
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Override
	public void edit(Product product)
	{
		String sql = "UPDATE dbo.Product SET name = ?, description = ?, price = ?, promotionalPrice = ?, quantity = ?, sold = ?, isActive = ?, isSelling = ?, categoryId = ?, storeId = ?, isDeleted = ? WHERE _id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setDouble(4, product.getPromotionalPrice());
			ps.setInt(5, product.getQuantity());
			ps.setInt(6, product.getSold());
			ps.setBoolean(7, product.getisActive());
			ps.setBoolean(8, product.getisSelling());
			ps.setInt(9, product.getCategoryId());
			ps.setInt(10, product.getStoreId());
			ps.setBoolean(11, product.getisDeleted());
			ps.setInt(12, product.get_id());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void editQuantity(Product product)
	{
		String sql = "update Product set quantity = ?\r\n"
				+ "where _id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, product.getQuantity());
			ps.setInt(2, product.get_id());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(int id)
	{
		String sql = "DELETE FROM dbo.Product WHERE _id = ?";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Override
	public List<Product> Top5Seller()
	{
		List<Product> productList = new ArrayList<Product>();
		String sql = "select * from Product order by sold desc";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int i = 0;
			while (rs.next()) {
				if(i>=5) break;
				Product product = new Product();
				product.set_id(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setSelling(rs.getBoolean("isSelling"));
				product.setDeleted(rs.getBoolean("isDeleted"));
				product.setRating(rs.getInt("rating"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setCreatedAt(rs.getDate("createdAt"));
				product.setUpdatedAt(rs.getDate("updatedAt"));
				if(rs.getInt("categoryId") != 0)
				{
					Category cate = cateService.findCategoryByID(rs.getInt("categoryId"));
					product.setCategory(cate);
				}
				if(rs.getInt("storeId") != 0)
				{
					Store store = storeService.findStoreByID(rs.getInt("storeId"));
					product.setStore(store);
				}
				productList.add(product);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}
	public List<Product> getTop5Product() {
		// Khai bao List de luu danh sach sp
		List<Product> list = new ArrayList<Product>();
		// khai bao chuoi truy van
		String sql = "select TOP 5 * from Product\r\n" + "order by _id ASC";
		try {
			Connection conn = super.getConnection();
			conn = new ConnectJDBC().getConnection();
			// mo ket noi DB
			// nem cau querry qua SQL
			PreparedStatement ps = conn.prepareStatement(sql);
			
			// chay querry va nhan ket qua
			ResultSet rs = ps.executeQuery();
			// lay tu resultset do vao list
			while (rs.next()) {
				list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),
						rs.getFloat(6),rs.getInt(7),rs.getInt(8),rs.getBoolean(9),rs.getBoolean(10),rs.getInt(11),rs.getInt(12),
						rs.getBoolean(13),rs.getInt(14),rs.getDate(15),rs.getDate(16)));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public int TotalProductSold()
	{
		int total = 0;
		List<Product> productList = findAllProduct();
		for (Product p : productList)
		{
			total += p.getSold();
		}
		return total;
	}
	public int getTotalProduct()
	{
		String sql = "select count(*) from Product";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public int coutbyId(int cateID)
	{
		String sql = "select count(*) from Product where categoryId=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cateID);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public double[] PercentOfTop()
	{
		double[] arr = new double[6];
		List<Product> productList = Top5Seller();
		int sum = 0;
		int i= 0;
		for (Product p : productList)
		{
			arr[i] = p.getSold();
			sum += p.getSold();
			i++;
		}
		
		arr[5] = TotalProductSold() - sum;
		
		return arr;
		
	}
	public Product getTop1Product() {
		// Khai bao List de luu danh sach sp
		Product pro = null;
		// khai bao chuoi truy van
		String sql = "SELECT * FROM Product\r\n"
				+ "WHERE sold = (Select Max(sold) from Product)\r\n"
				+ "";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// mo ket noi DB
			conn = new ConnectJDBC().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			// chay querry va nhan ket qua
			rs = ps.executeQuery();
			// lay tu resultset do vao list
			while (rs.next()) {
				pro = (new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),
						rs.getFloat(6),rs.getInt(7),rs.getInt(8),rs.getBoolean(9),rs.getBoolean(10),rs.getInt(11),rs.getInt(12),
						rs.getBoolean(13),rs.getInt(14),rs.getDate(15),rs.getDate(16)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return pro;
	}
	public List<Product> getlast4Product() {
		// Khai bao List de luu danh sach sp
		List<Product> list = new ArrayList<Product>();
		// khai bao chuoi truy van
		String sql = "select TOP 4 * from Product  order by sold ASC  ";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// mo ket noi DB
			conn = new ConnectJDBC().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			// chay querry va nhan ket qua
			rs = ps.executeQuery();
			// lay tu resultset do vao list
			while (rs.next()) {
				list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),
						rs.getFloat(6),rs.getInt(7),rs.getInt(8),rs.getBoolean(9),rs.getBoolean(10),rs.getInt(11),rs.getInt(12),
						rs.getBoolean(13),rs.getInt(14),rs.getDate(15),rs.getDate(16)));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public List<Product> searchbyName(String txtSearch) {
	       //Khai bao List de luu danh sach sp
			List<Product> list = new ArrayList<Product>();
	        //khai bao chuoi truy van 
			String sql = "select * from Product where name like ? ";
			try {
				// mo ket noi DB
				Connection conn = new ConnectJDBC().getConnection();
				// nem cau querry qua SQL
				PreparedStatement ps = conn.prepareStatement(sql);
				// gan gia tri cho dau hoi
				ps.setString(1, "%" +txtSearch + "%");
				// chay querry va nhan ket qua
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),
							rs.getFloat(6),rs.getInt(7),rs.getInt(8),rs.getBoolean(9),rs.getBoolean(10),rs.getInt(11),rs.getInt(12),
							rs.getBoolean(13),rs.getInt(14),rs.getDate(15),rs.getDate(16)));

				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return list;
		}
	
	public List<Product> pagingProduct(int index,int indexP) {
	       //Khai bao List de luu danh sach sp
			List<Product> list = new ArrayList<Product>();
	        //khai bao chuoi truy van 
			String sql = "select * from Product order by _id offset ? rows fetch next ? rows only ";
			try {
				// mo ket noi DB
				Connection conn = new ConnectJDBC().getConnection();
				// nem cau querry qua SQL
				PreparedStatement ps = conn.prepareStatement(sql);
				// gan gia tri cho dau hoi
				ps.setInt(1, (index-1)*3);
				ps.setInt(2, indexP+2);
				// chay querry va nhan ket qua
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),
							rs.getFloat(6),rs.getInt(7),rs.getInt(8),rs.getBoolean(9),rs.getBoolean(10),rs.getInt(11),rs.getInt(12),
							rs.getBoolean(13),rs.getInt(14),rs.getDate(15),rs.getDate(16)));

				}
				} catch (Exception e) {
				// TODO: handle exception
			}
			return list;
		}
	public List<Product> pagingProductbyId(int cateId, int index,int size) {
	       //Khai bao List de luu danh sach sp
			List<Product> list = new ArrayList<Product>();
	        //khai bao chuoi truy van 
			String sql = "with x as (select ROW_NUMBER() over (order by _id desc)as r,* from Product where categoryId = ? )\r\n"
					+ "select * from x where r between (?-3)*2 and ?*3 ";
			try {
				// mo ket noi DB
				Connection conn = new ConnectJDBC().getConnection();
				// nem cau querry qua SQL
				PreparedStatement ps = conn.prepareStatement(sql);
				// gan gia tri cho dau hoi
				ps.setInt(1, cateId);
				ps.setInt(2, index);
				ps.setInt(3, index);
				// chay querry va nhan ket qua
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),
							rs.getFloat(6),rs.getInt(7),rs.getInt(8),rs.getBoolean(9),rs.getBoolean(10),rs.getInt(11),rs.getInt(12),
							rs.getBoolean(13),rs.getInt(14),rs.getDate(15),rs.getDate(16)));

				}
				} catch (Exception e) {
				// TODO: handle exception
			}
			return list;
		}
	public static void main(String[] args)
	{
		ProductDaoImpl productDao = new ProductDaoImpl();
		//int pro = productDao.coutbyId(1);
		List<Product> list = productDao.searchbyName("elec");
		for(Product o:list)
		{
			System.out.println(o.get_id());
		}
		//System.out.println(pro);
		//List<ProductModel> listC = productDao.;
		/*
		 * for (CategoryModel o: listC ) { System.out.println(o); }
		 */
	}

	
}
