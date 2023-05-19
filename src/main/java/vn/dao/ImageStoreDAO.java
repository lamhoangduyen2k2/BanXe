package vn.dao;

import java.util.List;

import vn.models.*;

public interface ImageStoreDAO {
	List<ListImagesStore> findAllImage(int id);
	void insert(ListImagesStore model);
	void delete(int idStore, String image);
}
