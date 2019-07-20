package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.dto.CartProductDto;
import com.cafe24.shoppingmall.repository.CartDao;
import com.cafe24.shoppingmall.vo.ProductVo;

@Service
public class CartService {
	@Autowired
	private CartDao cartDao;
	
	public List<CartProductDto> getProductList(){
		List<CartProductDto> productList = cartDao.getCartList();
		return null;
	}
}
