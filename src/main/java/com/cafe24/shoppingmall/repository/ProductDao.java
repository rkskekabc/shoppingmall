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
		return sqlSession.selectList("product.getList");
	}

	public ProductVo get(Long no) {
		return sqlSession.selectOne("product.getByNo", no);
	}

	public Long insert(ProductVo vo) {
		sqlSession.insert("product.insert", vo);
		return vo.getNo();
	}

	public Long update(ProductVo vo) {
		sqlSession.update("product.update", vo);
		return vo.getNo();
	}

	public Boolean delete(Long no) {
		int result = sqlSession.delete("product.delete", no);
		return result == 1;
	}

}
