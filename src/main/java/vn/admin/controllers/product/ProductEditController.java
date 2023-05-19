package vn.admin.controllers.product;

import java.io.File; 
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.models.*;
import vn.service.*;
import vn.service.impl.*;
import vn.util.Constant;

@WebServlet(urlPatterns = ("/admin/product/edit"))
public class ProductEditController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StoreService storeService = new StoreServiceImpl();
	ProductService modelService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServiceImpl(); 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("_id");
		Product model = modelService.findProductByID(Integer.parseInt(id));
		req.setAttribute("model", model);
		List<Store> storeList = storeService.findAllStore();
		req.setAttribute("storeList", storeList);
		List<Category> cateList = cateService.findAllCategory();
		req.setAttribute("cateList", cateList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/product/product_edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product model = new Product();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("name")) {
					model.setName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("description")) {
					model.setDescription(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("price")) {
					model.setPrice(Double.parseDouble(item.getString()));
				} else if (item.getFieldName().equals("promotionalPrice")) {
					model.setPromotionalPrice(Double.parseDouble(item.getString()));
				} else if (item.getFieldName().equals("quantity")) {
					model.setQuantity(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("sold")) {
					model.setSold(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("isActive")) {
					model.setActive(Boolean.parseBoolean(item.getString()));
				} else if (item.getFieldName().equals("isSelling")) {
					model.setSelling(Boolean.parseBoolean(item.getString()));
				} else if (item.getFieldName().equals("isDeleted")) {
					model.setDeleted(Boolean.parseBoolean(item.getString()));
				} else if (item.getFieldName().equals("categoryId")) {
					model.setCategoryId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("ids")) {
					model.setStoreId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("_id")) {
					model.set_id(Integer.parseInt(item.getString()));
				} 
			}
			modelService.edit(model);
			resp.sendRedirect(req.getContextPath() + "/admin/product");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
