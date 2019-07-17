package com.cafe24.shoppingmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.ProductVo;

@Repository
public class ProductDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<ProductVo> getList() {
		return null;
	}

	public Long insert(ProductVo vo) {
		sqlSession.insert("product.insert", vo);
		return vo.getNo();
	}

}
