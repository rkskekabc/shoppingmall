package com.cafe24.shoppingmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.OptionParentVo;

@Repository
public class OptionParentDao {
	@Autowired
	private SqlSession sqlSession;
	
	public Long insert(OptionParentVo vo) {
		sqlSession.insert("optionparent.insert", vo);
		return vo.getNo();
	}
	
	public List<OptionParentVo> getList(){
		return sqlSession.selectList("optionparent.getList");
	}
	
	public Long update(OptionParentVo vo) {
		sqlSession.update("optionparent.update", vo);
		return vo.getNo();
	}
	
	public Boolean delete(Long no) {
		sqlSession.delete("optionparent.delete", no);
		return true;
	}
}
