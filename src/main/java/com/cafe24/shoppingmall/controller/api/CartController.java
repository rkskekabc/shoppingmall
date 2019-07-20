package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.CartProductDto;
import com.cafe24.shoppingmall.dto.ProductOrderDto;
import com.cafe24.shoppingmall.service.CartService;
import com.cafe24.shoppingmall.vo.ProductVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("cartAPIController")
@RequestMapping("/api/cart")
public class CartController {
	@Autowired
	private CartService cartService;

	@ApiOperation(value="장바구니목록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="memberNo", value="사용자번호", required=true, dataType="long", defaultValue="")
	})
	@GetMapping("/{memberNo}")
	public List<CartProductDto> getCart(@PathVariable Long memberNo){
		return null;
	}

	@ApiOperation(value="장바구니등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="memberNo", value="사용자번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="productNo", value="상품번호", required=true, dataType="long", defaultValue="")
	})
	@PostMapping("/")
	public List<ProductVo> inputCart(@RequestBody ProductOrderDto dto){
		return null;
	}

	@ApiOperation(value="장바구니에서 제거")
	@ApiImplicitParams({
		@ApiImplicitParam(name="memberNo", value="사용자번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="productNo", value="상품번호", required=true, dataType="long", defaultValue="")
	})
	@DeleteMapping("/")
	public List<ProductVo> deleteFromCart(@RequestBody ProductOrderDto dto){
		return null;
	}

	@ApiOperation(value="장바구니 비우기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="memberNo", value="사용자번호", required=true, dataType="long", defaultValue="")
	})
	@DeleteMapping("/{memberNo}")
	public List<ProductVo> removeCart(@RequestBody Long memberNo){
		return null;
	}
}
