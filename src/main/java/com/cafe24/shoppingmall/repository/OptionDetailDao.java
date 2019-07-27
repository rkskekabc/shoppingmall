package com.cafe24.shoppingmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.dto.OptionDetailInfoDto;

@Repository
public class OptionDetailDao {
	@Autowired
	private SqlSession sqlSession;

	public List<OptionDetailInfoDto> getList() {
		return sqlSession.selectList("optionDetail.getList");
	}
	
}
