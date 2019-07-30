package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.ProductDao;
import com.cafe24.shoppingmall.vo.ProductVo;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	public List<ProductVo> getList() {
		return productDao.getList();
	}
	
	public List<ProductVo> getList(String categoryNo, String searchText) {
		return productDao.getList();
	}

	public ProductVo get(Long no) {
		return productDao.get(no);
	}

	public Long insert(ProductVo vo) {
		return productDao.insert(vo);
	}

	public Long update(Long no, ProductVo vo) {
		vo.setNo(no);
		return productDao.update(vo);
	}

	public Boolean delete(Long no) {
		return productDao.delete(no);
	}

}
