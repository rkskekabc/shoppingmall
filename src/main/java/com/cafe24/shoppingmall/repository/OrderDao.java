package com.cafe24.shoppingmall.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("memberNo", memberNo);
		paramMap.put("aesKey", aesKey);
		return sqlSession.selectList("orderhistory.getList", paramMap);
	}

	public OrderHistoryVo get(Long no) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("no", no);
		paramMap.put("aesKey", aesKey);
		return sqlSession.selectOne("orderhistory.getByNo", paramMap);
	}
	
	public Integer insert(OrderHistoryVo vo) {
		vo.setAesKey(aesKey);
		return sqlSession.insert("orderhistory.insert", vo);
	}
}
