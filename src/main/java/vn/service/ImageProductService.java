package vn.service;

import java.util.List;

import vn.models.*;

public interface ImageProductService {
	List<ListImagesProduct> findAllImage(int id);
	List<ListImagesProduct> getAllImage();
	void insert(ListImagesProduct model);
	void delete(int idStore, String image);
}
