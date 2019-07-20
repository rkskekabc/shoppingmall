package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cafe24.shoppingmall.service.CartService;
import com.cafe24.shoppingmall.vo.ProductVo;

@Controller
public class CartController {
	@Autowired
	private CartService service;
	
	public List<ProductVo> getProductList(Long memberNo){
		return null;
	}
}
