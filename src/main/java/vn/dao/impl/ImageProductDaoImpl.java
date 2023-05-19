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

public class ImageProductDaoImpl extends ConnectJDBC implements ImageProductDAO{
	ProductService productService = new ProductServiceImpl();
	
	@Override
	public List<ListImagesProduct> findAllImage(int id) {
		List<ListImagesProduct> imageList = new ArrayList<ListImagesProduct>();
		String sql = "Select * from ListImagesProduct where _id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ListImagesProduct img = new ListImagesProduct();
				img.set_id(rs.getInt("_id"));
				img.setImage(rs.getString("image"));
				if(rs.getInt("_id") != 0)
				{
					Product pro = productService.findProductByID(rs.getInt("_id"));
					img.setProduct(pro);
				}
				imageList.add(img);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageList;
	}
	
	@Override
	public List<ListImagesProduct> getAllImage() {
		List<ListImagesProduct> imageList = new ArrayList<ListImagesProduct>();
		String sql = "Select * from ListImagesProduct";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ListImagesProduct img = new ListImagesProduct();
				img.set_id(rs.getInt("_id"));
				img.setImage(rs.getString("image"));
				if(rs.getInt("_id") != 0)
				{
					Product pro = productService.findProductByID(rs.getInt("_id"));
					img.setProduct(pro);
				}
				imageList.add(img);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageList;
	}
	
	@Override
	public void insert(ListImagesProduct model)
	{
		String sql = "insert into dbo.ListImagesProduct\r\n"
				+ "(\r\n"
				+ "	_id,\r\n"
				+ "	image\r\n"
				+ ")\r\n"
				+ "values\r\n"
				+ "(\r\n"
				+ "	?,\r\n"
				+ "	?\r\n"
				+ ")";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, model.get_id());
		ps.setString(2, model.getImage());
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Override
	public void delete(int idProduct, String image)
	{
		String sql = "delete from dbo.ListImagesProduct where _id = ? and image = ?";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, idProduct);
		ps.setString(2, image);
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
