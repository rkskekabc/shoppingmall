package com.cafe24.shoppingmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.ProductOptionVo;

@Repository
public class ProductOptionDao {
	@Autowired
	private SqlSession sqlSession;

	public List<ProductOptionVo> getList() {
		return sqlSession.selectList("productoption.getList");
	}
	
	public Long insert(ProductOptionVo vo) {
		sqlSession.insert("productoption.insert", vo);
		return vo.getNo();
	}

	public Long update(ProductOptionVo vo) {
		sqlSession.update("productoption.update", vo);
		return vo.getNo();
	}

	public Boolean delete(Long no) {
		int result = sqlSession.delete("productoption.delete", no);
		return result == 1;
	}
}
