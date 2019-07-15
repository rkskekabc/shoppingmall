package com.cafe24.shoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.MemberDao;
import com.cafe24.shoppingmall.vo.MemberVo;

@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;
	
	public Long join(MemberVo vo) {
		return memberDao.insert(vo);
	}
	
	public Boolean existEmail(String email) {
		return memberDao.get(email) != null;
	}
}
