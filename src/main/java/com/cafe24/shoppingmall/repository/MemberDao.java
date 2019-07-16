package com.cafe24.shoppingmall.repository;

import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.MemberVo;

@Repository
public class MemberDao {
	
//	@Autowired
//	SqlSession sqlSession;

	public MemberVo testData() {
		MemberVo vo = new MemberVo();
		vo.setNo(1L);
		vo.setId("rkskek");
		vo.setEmail("rkskek@rkskek.com");
		vo.setPassword("1234");
		return vo;
	}
	public Long insert(MemberVo vo) {
		Long insert_result = testData().getNo();
		return insert_result;
	}

	public MemberVo getByEmail(String email) {
		if(testData().getEmail().equals(email)) {
			return testData();
		} else {
			return null;
		}
	}
	
	public MemberVo getById(String id) {
		if(testData().getId().equals(id)) {
			return testData();
		} else {
			return null;
		}
	}
	public Long get(MemberVo vo) {
		if(vo.getId().equals(testData().getId()) && vo.getPassword().equals(testData().getPassword())) {
			return testData().getNo();
		} else {
			return -1L;
		}
	}
	public Long update(MemberVo vo) {
		if(vo.getNo() == testData().getNo()) {
			return testData().getNo();
		} else {
			return -1L;
		}
	}
}
