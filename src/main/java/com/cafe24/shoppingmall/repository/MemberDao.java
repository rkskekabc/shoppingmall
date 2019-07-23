package com.cafe24.shoppingmall.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.MemberVo;

@Repository
public class MemberDao {
	private final String aesKey = "key";
	
	@Autowired
	private SqlSession sqlSession;

	public MemberVo testData() {
		MemberVo vo = new MemberVo();
		vo.setNo(1L);
		vo.setId("rkskek");
		vo.setEmail("rkskek@rkskek.com");
		vo.setPassword("1234");
		return vo;
	}
	
	public Long insert(MemberVo vo) { 
		sqlSession.insert("member.insert", vo);
		return vo.getNo();
	}

	public MemberVo getByEmail(MemberVo vo) {
		vo.setAesKey(aesKey);
		return sqlSession.selectOne("member.getByEmail", vo);
	}
	
	public MemberVo getById(MemberVo vo) {
		vo.setAesKey(aesKey);
		return sqlSession.selectOne("member.getById", vo);
	}
	
	public MemberVo getByNo(MemberVo vo) {
		vo.setAesKey(aesKey);
		return sqlSession.selectOne("member.getByNo", vo);
	}
	
	public MemberVo get(MemberVo vo) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("id", vo.getId());
		paramMap.put("password", vo.getPassword());
		paramMap.put("aesKey", aesKey);
		return sqlSession.selectOne("member.getByIdAndPassword", paramMap);
	}
	public Long update(MemberVo vo) {
		vo.setAesKey(aesKey);
		sqlSession.update("member.update", vo);
		return vo.getNo();
	}
}
