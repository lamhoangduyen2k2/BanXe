package vn.service.impl;

import java.util.List;

import vn.dao.*;
import vn.dao.impl.*;
import vn.models.*;
import vn.service.*;

public class ImageProductServiceImpl implements ImageProductService{
	ImageProductDAO modelDao = new ImageProductDaoImpl();

	@Override
	public List<ListImagesProduct> findAllImage(int id) {
		return modelDao.findAllImage(id);
	}
	
	@Override
	public List<ListImagesProduct> getAllImage() {
		return modelDao.getAllImage();
	}

	@Override
	public void insert(ListImagesProduct model) {
		modelDao.insert(model);
	}
	
	@Override
	public void delete(int idProduct, String image) {
		modelDao.delete(idProduct, image);
	}
}
