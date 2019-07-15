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
		vo.setEmail("rkskek@rkskek.com");
		vo.setPassword("1234");
		return vo;
	}
	public Long insert(MemberVo vo) {
		Long insert_result = testData().getNo();
		return insert_result;
	}

	public MemberVo get(String email) {
		System.out.println(email);
		if(testData().getEmail().equals(email)) {
			return testData();
		} else {
			return null;
		}
	}
	
}
