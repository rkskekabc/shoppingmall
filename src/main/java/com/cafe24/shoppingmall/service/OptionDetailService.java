package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.dto.OptionDetailInfoDto;
import com.cafe24.shoppingmall.repository.OptionDetailDao;

@Service
public class OptionDetailService {
	@Autowired
	private OptionDetailDao optionDetailDao;

	public List<OptionDetailInfoDto> getList() {
		return optionDetailDao.getList();
	}
	
	
}
