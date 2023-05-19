package vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.connection.ConnectJDBC;
import vn.dao.CategoryDAO;
import vn.models.Category;
import vn.service.CategoryService;
import vn.service.impl.CategoryServiceImpl;

public class CategoryDaoImpl extends ConnectJDBC implements CategoryDAO{
	
	@Override
	public List<Category> findAllCategory() {
		List<Category> cateList = new ArrayList<Category>();
		String sql = "Select * from Category";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category cate = new Category();
				cate.set_id(rs.getInt("_id"));
				cate.set_name(rs.getString("_name"));
				cate.setSlug(rs.getString("slug"));
				cate.setCategoryId(rs.getInt("categoryId"));
				cate.set_image(rs.getString("_image"));
				cate.setDeleted(rs.getBoolean("isDeleted"));
				cate.setCreatedAt(rs.getDate("createdAt"));
				cate.setUpdatedAt(rs.getDate("updatedAt"));
				if(rs.getInt("categoryId") != 0)
				{
					Category catef = findCategoryByID(rs.getInt("categoryId"));
					cate.setCategory(catef);
				}
				cateList.add(cate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cateList;
	}
	
	@Override
	public Category findCategoryByID(int _id) {
		String sql = "Select * From Category where _id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, _id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { // duyệt từng dòng trong ResultSet trả về danh sách đối tượng
				Category cate = new Category();
				cate.set_id(rs.getInt("_id"));
				cate.set_name(rs.getString("_name"));
				cate.setSlug(rs.getString("slug"));
				cate.setCategoryId(rs.getInt("categoryId"));
				cate.set_image(rs.getString("_image"));
				cate.setDeleted(rs.getBoolean("isDeleted"));
				cate.setCreatedAt(rs.getDate("createdAt"));
				cate.setUpdatedAt(rs.getDate("updatedAt"));
				if(rs.getInt("categoryId") != 0)
				{
					Category catef = findCategoryByID(rs.getInt("categoryId"));
					cate.setCategory(catef);
				}
				return cate;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void insert(Category category)
	{
		String sql = "INSERT INTO dbo.Category\r\n"
				+ "(\r\n"
				+ "    _name,\r\n"
				+ "    categoryId,\r\n"
				+ "    _image\r\n"
				+ ")\r\n"
				+ "VALUES\r\n"
				+ "(   ?,     -- _name - nvarchar(32)\r\n"
				+ "    ?,    -- categoryId - int\r\n"
				+ "    ?    -- _image - nvarchar(500)\r\n"
				+ "    )";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, category.get_name());
		if(category.getCategoryId() == 0)
			ps.setString(2, null);
		else
			ps.setInt(2, category.getCategoryId());
		ps.setString(3, category.get_image());
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Override
	public void edit(Category category)
	{
		String sql = "UPDATE dbo.Category SET _name = ?, categoryId = ?, _image = ?, isDeleted = ? WHERE _id = ?";
				try {
				Connection con = super.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, category.get_name());
				if(category.getCategoryId() == 0)
					ps.setString(2, null);
				else
					ps.setInt(2, category.getCategoryId());
				ps.setString(3, category.get_image());
				ps.setBoolean(4, category.getisDeleted());
				ps.setInt(5, category.get_id());
				ps.executeUpdate();
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	}
	
	@Override
	public void delete(int id)
	{
		String sql = "DELETE FROM dbo.Category WHERE _id = ?";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
