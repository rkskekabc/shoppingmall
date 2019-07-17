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
	
	public List<ProductVo> getList(String categoryNo, String searchText) {
		return productDao.getList();
	}

	public Long insert(ProductVo vo) {
		return productDao.insert(vo);
	}

	public Long update(ProductVo vo) {
		return productDao.update(vo);
	}

	public Boolean delete(Long no) {
		return productDao.delete(no);
	}

}
