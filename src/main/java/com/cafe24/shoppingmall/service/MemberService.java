package com.cafe24.shoppingmall.service;

import java.util.List;

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

	public List<MemberVo> getList() {
		MemberVo vo = new MemberVo();
		return memberDao.getList(vo);
	}

	public MemberVo getById(String id) {
		MemberVo vo = new MemberVo();
		vo.setId(id);
		return memberDao.getById(vo);
	}

	public MemberVo login(MemberVo vo) {
		return memberDao.get(vo);
	}

	public Long update(Long no, MemberVo vo) {
		vo.setNo(no);
		return memberDao.update(vo);
	}
}
