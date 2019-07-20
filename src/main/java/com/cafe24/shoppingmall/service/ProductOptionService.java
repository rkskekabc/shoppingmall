package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.ProductOptionDao;
import com.cafe24.shoppingmall.vo.ProductOptionVo;

@Service
public class ProductOptionService {
	@Autowired
	private ProductOptionDao productOptionDao;

	public List<ProductOptionVo> getList() {
		return productOptionDao.getList();
	}
	
	public Long insert(ProductOptionVo vo) {
		return productOptionDao.insert(vo);
	}

	public Long update(ProductOptionVo vo) {
		return productOptionDao.update(vo);
	}

	public Boolean delete(Long no) {
		return productOptionDao.delete(no);
	}
}
