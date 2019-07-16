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
	
	public Boolean existEmail(MemberVo vo) {
		return memberDao.getByEmail(vo) != null;
	}

	public Boolean existId(MemberVo vo) {
		return memberDao.getById(vo) != null;
	}

	public MemberVo login(MemberVo vo) {
		return memberDao.get(vo);
	}

	public Long update(MemberVo vo) {
		return memberDao.update(vo);
	}
}
