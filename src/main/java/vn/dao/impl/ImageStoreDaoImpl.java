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

public class ImageStoreDaoImpl extends ConnectJDBC implements ImageStoreDAO{
	StoreService storeService = new StoreServiceImpl();
	
	@Override
	public List<ListImagesStore> findAllImage(int id) {
		List<ListImagesStore> imageList = new ArrayList<ListImagesStore>();
		String sql = "Select * from ListImagesStore where _id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ListImagesStore img = new ListImagesStore();
				img.set_id(rs.getInt("_id"));
				img.setFeatured_image(rs.getString("featured_image"));
				if(rs.getInt("_id") != 0)
				{
					Store store = storeService.findStoreByID(rs.getInt("_id"));
					img.setStore(store);
				}
				imageList.add(img);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageList;
	}
	
	@Override
	public void insert(ListImagesStore model)
	{
		String sql = "insert into dbo.ListImagesStore\r\n"
				+ "(\r\n"
				+ "	_id,\r\n"
				+ "	featured_image\r\n"
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
		ps.setString(2, model.getFeatured_image());
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Override
	public void delete(int idStore, String image)
	{
		String sql = "delete from dbo.ListImagesStore where _id = ? and featured_image = ?";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, idStore);
		ps.setString(2, image);
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
