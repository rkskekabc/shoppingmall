package com.cafe24.shoppingmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.OptionChildVo;
import com.cafe24.shoppingmall.vo.OptionParentVo;

@Repository
public class OptionChildDao {
	@Autowired
	private SqlSession sqlSession;

	public List<OptionChildVo> getList() {
		return sqlSession.selectList("optionchild.getList");
	}

	public List<OptionParentVo> getWithParentList(Long optionParentNo) {
		return sqlSession.selectList("optionchild.getByParentNo", optionParentNo);
	}

	public Long insert(OptionChildVo vo) {
		sqlSession.insert("optionchild.insert", vo);
		return vo.getNo();
	}

	public Long update(OptionChildVo vo) {
		sqlSession.update("optionchild.update", vo);
		return vo.getNo();
	}

	public Boolean delete(Long no) {
		sqlSession.delete("optionchild.delete", no);
		return true;
	}
}
