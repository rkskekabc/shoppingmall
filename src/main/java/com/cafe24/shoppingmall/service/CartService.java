package com.cafe24.shoppingmall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.dto.OptionDetailInfoDto;
import com.cafe24.shoppingmall.repository.CartDao;
import com.cafe24.shoppingmall.repository.OptionDetailDao;
import com.cafe24.shoppingmall.vo.CartVo;

@Service
public class CartService {
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private OptionDetailDao optionDetailDao;
	
	public List<OptionDetailInfoDto> getCartList(Long memberNo){
		List<CartVo> cartList = cartDao.getCartList(memberNo);
		List<OptionDetailInfoDto> optionList = new ArrayList<OptionDetailInfoDto>();
		for(CartVo vo : cartList) {
			OptionDetailInfoDto dto = optionDetailDao.getByNo(vo.getOptionDetailNo());
			optionList.add(dto);
		}
		return optionList;
	}

	public Boolean inputCart(CartVo vo) {
		return cartDao.inputCart(vo);
	}

	public Integer updateCart(CartVo vo) {
		return cartDao.updateCart(vo);
	}

	public Integer removeProduct(CartVo vo) {
		return cartDao.deleteOne(vo);
	}

	public Integer removeCart(Long memberNo) {
		return cartDao.deleteAll(memberNo);
	}
}
