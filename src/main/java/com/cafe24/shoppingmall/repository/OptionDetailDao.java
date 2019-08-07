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
		return sqlSession.selectList("optiondetail.getList");
	}

	public OptionDetailInfoDto getByNo(Long no) {
		return sqlSession.selectOne("optiondetail.getByNo", no);
	}

	public List<OptionDetailInfoDto> getByProductNo(Long productNo) {
		return sqlSession.selectList("optiondetail.getByProductNo", productNo);
	}

	public Long insert(OptionDetailVo vo) {
		sqlSession.insert("optiondetail.insert", vo);
		return vo.getNo();
	}

	public Long update(OptionDetailVo vo) {
		sqlSession.update("optiondetail.update", vo);
		return vo.getNo();
	}

	public Boolean delete(Long no) {
		sqlSession.delete("optiondetail.delete", no);
		return true;
	}
}
