package com.cafe24.shoppingmall.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.HistoryProductVo;

@Repository
public class HistoryProductDao {
	@Autowired
	private SqlSession sqlSession;
	
	public Integer insert(HistoryProductVo vo) {
		return sqlSession.insert("historyproduct.insert", vo);
	}
}
