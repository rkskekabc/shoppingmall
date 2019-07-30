package com.cafe24.shoppingmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.CategoryVo;

@Repository
public class CategoryDao {
	@Autowired
	private SqlSession sqlSession;

	public List<CategoryVo> getList() {
		return sqlSession.selectList("category.getList");
	}

	public CategoryVo get(Long no) {
		return sqlSession.selectOne("category.getByNo", no);
	}
	
	public Long insert(CategoryVo vo) {
		sqlSession.insert("category.insert", vo);
		return vo.getNo();
	}

	public CategoryVo getByNo(Long no) {
		return sqlSession.selectOne("category.getByNo", no);
	}

	public Long update(CategoryVo categoryVo) {
		sqlSession.update("category.update", categoryVo);
		return categoryVo.getNo();
	}
	
	public Integer delete(Long no) {
		return sqlSession.delete("category.delete", no);
	}
}
