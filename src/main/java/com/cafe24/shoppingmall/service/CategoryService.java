package com.cafe24.shoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.CategoryDao;
import com.cafe24.shoppingmall.vo.CategoryVo;

@Service
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	
	public Long add(CategoryVo vo) {
		return categoryDao.insert(vo);
	}
	
	public Long update(Long no, CategoryVo vo) {
		vo.setNo(no);
		return categoryDao.update(vo);
	}
	
	public Boolean delete(Long no) {
		return 0 != categoryDao.delete(no);
	}
}
