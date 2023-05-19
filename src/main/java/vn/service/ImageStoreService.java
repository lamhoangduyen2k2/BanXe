package vn.service;

import java.util.List;

import vn.models.*;

public interface ImageStoreService {
	List<ListImagesStore> findAllImage(int id);
	void insert(ListImagesStore model);
	void delete(int idStore, String image);
}
