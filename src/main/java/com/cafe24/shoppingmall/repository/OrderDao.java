package com.cafe24.shoppingmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.OrderHistoryVo;

@Repository
public class OrderDao {
	@Autowired
	private SqlSession sqlSession;

	public List<OrderHistoryVo> getList() {
		return sqlSession.selectList("orderhistory.getList");
	}

	public OrderHistoryVo get(Long no) {
		return sqlSession.selectOne("orderhistory.getByNo", no);
	}
	
	public Long insert() {
		return null;
	}
}
