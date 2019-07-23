package com.cafe24.shoppingmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.OrderHistoryVo;

@Repository
public class OrderDao {
	private final String aesKey = "key";
	
	@Autowired
	private SqlSession sqlSession;

	public List<OrderHistoryVo> getList(Long memberNo) {
		return sqlSession.selectList("orderhistory.getList", memberNo);
	}

	public OrderHistoryVo get(Long no) {
		return sqlSession.selectOne("orderhistory.getByNo", no);
	}
	
	public Integer insert(OrderHistoryVo vo) {
		vo.setAesKey(aesKey);
		return sqlSession.insert("orderhistory.insert", vo);
	}
}
