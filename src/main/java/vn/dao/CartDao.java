package vn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.connection.ConnectJDBC;
import vn.models.*;
import vn.service.ProductService;
import vn.service.impl.ProductServiceImpl;

public class CartDao extends ConnectJDBC {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ProductService productService = new ProductServiceImpl();
	public List<Cart> getAll(){
		//Khai bao List de luu danh sach sp
		List<Cart> list = new ArrayList<Cart>();
		//khai bao chuoi truy van 
		String sql ="SELECT * FROM Cart";
		try {
			//mo ket noi DB
			conn = new ConnectJDBC().getConnection();
			//nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			//chay querry va nhan ket qua
			rs = ps.executeQuery();
			//lay tu resultset do vao list
			while (rs.next())
			{
				//list.add(new CartModel())
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public void addCartItem(CartItem cartItem) {
		String sql = "insert into CartItem (cartId,productId,count_SP) values (?,?,?)";
		try {
			// mo ket noi DB
			conn = new ConnectJDBC().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			// gan gia tri cho dau hoi
			ps.setInt(1, cartItem.getCartId());
			ps.setInt(2, cartItem.getProductId());
			ps.setInt(3, cartItem.getCount_SP());
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void addCart(_User user) {
		String sql = "insert into Cart (userId) values (?)";
		try {
			// mo ket noi DB
			conn = new ConnectJDBC().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			// gan gia tri cho dau hoi
			ps.setInt(1, user.get_id());
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public int findcartId(int userId) {
		Connection conn = null;
		String sql = "Select _id From Cart Where userId=?";
		try {
			conn = new ConnectJDBC().getConnection();//getConnetion ket noi db
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);			
			rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//nếu sản phẩm ko có trong kho hàng do ko được seller tạo
		return -1;
	}

	public List<CartItem> getAllCartItemByCartId(int caId) {
		String sql = "select * from CartItem where cartId = ?";
		List<CartItem> list = new ArrayList<CartItem>();
		try {
			conn = new ConnectJDBC().getConnection();//getConnetion ket noi db
			ps = conn.prepareStatement(sql);
			ps.setInt(1, caId);			
			rs = ps.executeQuery();
			while(rs.next()) {
				CartItem cartItem = new CartItem();
				cartItem.set_id(rs.getInt("_id"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setProductId(rs.getInt("productId"));
				cartItem.setCount_SP(rs.getInt("count_SP"));
				cartItem.setCreatedAt(rs.getDate("createdAt"));
				cartItem.setUpdatedAT(rs.getDate("updatedAT"));
				if(rs.getInt("productId") != 0 ) {
					Product product = productService.findProductByID(rs.getInt("productId"));
					cartItem.setProduct(product);
				}
				list.add(cartItem);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;		
	}
	public void increaseitem(CartItem cartItem) {
		String sql = "update CartItem set count_SP = count_SP + 1 where _id = ?";
		try {
			// mo ket noi DB
			conn = new ConnectJDBC().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			// gan gia tri cho dau hoi
			ps.setInt(1, cartItem.get_id());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void descreaseitem(CartItem cartItem) {
		String sql = "update CartItem set count_SP = count_SP - 1 where _id = ?";
		try {
			// mo ket noi DB
			conn = new ConnectJDBC().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			// gan gia tri cho dau hoi
			ps.setInt(1, cartItem.get_id());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void remove(CartItem cartItem) {
		String sql = "delete from CartItem where _id = ?";
		try {
			// mo ket noi DB
			conn = new ConnectJDBC().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			// gan gia tri cho dau hoi
			ps.setInt(1, cartItem.get_id());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public CartItem findCartItemById(int caitemId) {
		CartItem cartItem = new CartItem();
		String sql = "select * from CartItem where _id = ?";
		try {
			conn = new ConnectJDBC().getConnection();//getConnetion ket noi db
			ps = conn.prepareStatement(sql);
			ps.setInt(1, caitemId);			
			rs = ps.executeQuery();
			while (rs.next()) {
				cartItem.set_id(rs.getInt("_id"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setProductId(rs.getInt("productId"));
				cartItem.setCount_SP(rs.getInt("count_SP"));
				cartItem.setCreatedAt(rs.getDate("createdAt"));
				cartItem.setUpdatedAT(rs.getDate("updatedAT"));
				if(rs.getInt("productId") != 0 ) {
					Product product = productService.findProductByID(rs.getInt("productId"));
					cartItem.setProduct(product);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return cartItem;
	}
	
	public boolean checkCountSP(int count_Sp, int quantity) {
		if(count_Sp < quantity) {
			return true;
		}
		return false;
	}
	public static void main(String[] args)
	{
		CartDao cartDao = new CartDao();
		int a = cartDao.findcartId(13);
		System.out.print(a);
	}
}
