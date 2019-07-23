package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.dto.CartProductDto;
import com.cafe24.shoppingmall.dto.ProductOrderDto;
import com.cafe24.shoppingmall.repository.CartDao;
import com.cafe24.shoppingmall.vo.CartVo;

@Service
public class CartService {
	@Autowired
	private CartDao cartDao;
	
	public List<CartProductDto> getCartProductList(Long memberNo){
		List<CartProductDto> cartList = cartDao.getCartProductList(memberNo);
		return cartList;
	}

	public Boolean inputCart(CartVo vo) {
		return cartDao.inputCart(vo);
	}

	public Integer updateCart(CartVo vo) {
		return cartDao.updateCart(vo);
	}

	public Integer removeProduct(ProductOrderDto dto) {
		return cartDao.deleteOne(dto);
	}

	public Integer removeCart(Long memberNo) {
		return cartDao.deleteAll(memberNo);
	}
}
