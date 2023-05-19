package vn.dao;

import java.util.List;

import vn.models.*;

public interface ImageProductDAO {
	List<ListImagesProduct> findAllImage(int id);
	List<ListImagesProduct> getAllImage();
	void insert(ListImagesProduct model);
	void delete(int idProduct, String image);
}
