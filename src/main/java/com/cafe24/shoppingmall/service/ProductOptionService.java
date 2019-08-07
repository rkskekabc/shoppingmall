package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.OptionChildDao;
import com.cafe24.shoppingmall.repository.OptionParentDao;
import com.cafe24.shoppingmall.vo.OptionChildVo;
import com.cafe24.shoppingmall.vo.OptionParentVo;

@Service
public class ProductOptionService {
	@Autowired
	private OptionParentDao optionParentDao;

	@Autowired
	private OptionChildDao optionChildDao;

	public List<OptionParentVo> getOptionParentList() {
		return optionParentDao.getList();
	}

	public OptionParentVo getOptionParentByNo(Long no) {
		return optionParentDao.getByNo(no);
	}

	public Long insertOptionParent(OptionParentVo vo) {
		return optionParentDao.insert(vo);
	}

	public Long updateOptionParent(Long no, OptionParentVo vo) {
		vo.setNo(no);
		return optionParentDao.update(vo);
	}

	public Boolean deleteOptionParent(Long no) {
		return optionParentDao.delete(no);
	}

	public List<OptionChildVo> getOptionChildList() {
		return optionChildDao.getList();
	}

	public List<OptionParentVo> getOptionChildWithParentList(Long optionParentNo) {
		return optionChildDao.getWithParentList(optionParentNo);
	}

	public Long insertOptionChild(OptionChildVo vo) {
		return optionChildDao.insert(vo);
	}

	public Long updateOptionChild(Long no, OptionChildVo vo) {
		vo.setNo(no);
		return optionChildDao.update(vo);
	}

	public Boolean deleteOptionChild(Long no) {
		return optionChildDao.delete(no);
	}
}
