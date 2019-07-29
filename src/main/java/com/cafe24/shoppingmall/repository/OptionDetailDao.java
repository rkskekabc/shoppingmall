package com.cafe24.shoppingmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.dto.OptionDetailInfoDto;
import com.cafe24.shoppingmall.vo.OptionDetailVo;

@Repository
public class OptionDetailDao {
	@Autowired
	private SqlSession sqlSession;

	public List<OptionDetailInfoDto> getList() {
		return sqlSession.selectList("optionDetail.getList");
	}

	public Long insert(OptionDetailVo vo) {
		sqlSession.insert("optionDetail.insert", vo);
		return vo.getNo();
	}

	public Long update(OptionDetailVo vo) {
		sqlSession.update("optionDetail.update", vo);
		return vo.getNo();
	}

	public Boolean delete(Long no) {
		sqlSession.delete("optionDetail.delete", no);
		return true;
	}
}
