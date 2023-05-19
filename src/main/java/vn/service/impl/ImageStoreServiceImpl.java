package vn.service.impl;

import java.util.List;

import vn.dao.*;
import vn.dao.impl.*;
import vn.models.*;
import vn.service.*;

public class ImageStoreServiceImpl implements ImageStoreService{
	ImageStoreDAO modelDao = new ImageStoreDaoImpl();

	@Override
	public List<ListImagesStore> findAllImage(int id) {
		return modelDao.findAllImage(id);
	}

	@Override
	public void insert(ListImagesStore model) {
		modelDao.insert(model);
	}
	
	@Override
	public void delete(int idStore, String image) {
		modelDao.delete(idStore, image);
	}
}
