package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.dto.OptionDetailInfoDto;
import com.cafe24.shoppingmall.repository.OptionDetailDao;
import com.cafe24.shoppingmall.vo.OptionDetailVo;

@Service
public class OptionDetailService {
	@Autowired
	private OptionDetailDao optionDetailDao;

	public List<OptionDetailInfoDto> getList() {
		return optionDetailDao.getList();
	}

	public Long insert(OptionDetailVo vo) {
		return optionDetailDao.insert(vo);
	}

	public Long update(Long no, OptionDetailVo vo) {
		vo.setNo(no);
		return optionDetailDao.update(vo);
	}

	public Boolean delete(Long no) {
		return optionDetailDao.delete(no);
	}
}
