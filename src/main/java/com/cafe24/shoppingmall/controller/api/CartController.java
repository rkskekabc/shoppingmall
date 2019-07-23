package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.CartProductDto;
import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.dto.ProductOrderDto;
import com.cafe24.shoppingmall.service.CartService;
import com.cafe24.shoppingmall.vo.CartVo;

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
	public ResponseEntity<JSONResult> getCart(@PathVariable Long memberNo){
		List<CartProductDto> dto = cartService.getCartProductList(memberNo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(dto));
	}

	@ApiOperation(value="장바구니등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="memberNo", value="사용자번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="productNo", value="상품번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="num", value="개수", required=true, dataType="int", defaultValue=""),
		@ApiImplicitParam(name="price", value="가격", required=true, dataType="int", defaultValue="")
	})
	@PostMapping("/")
	public ResponseEntity<JSONResult> inputCart(@RequestBody CartVo vo){
		Boolean result = cartService.inputCart(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}

	@ApiOperation(value="장바구니수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name="memberNo", value="사용자번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="productNo", value="상품번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="num", value="개수", required=true, dataType="int", defaultValue=""),
		@ApiImplicitParam(name="price", value="가격", required=true, dataType="int", defaultValue="")
	})
	@PutMapping("/")
	public ResponseEntity<JSONResult> updateCart(@RequestBody CartVo vo){
		Integer result = cartService.updateCart(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}

	@ApiOperation(value="장바구니에서 제거")
	@ApiImplicitParams({
		@ApiImplicitParam(name="memberNo", value="사용자번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="productNo", value="상품번호", required=true, dataType="long", defaultValue="")
	})
	@DeleteMapping("/")
	public ResponseEntity<JSONResult> deleteFromCart(@RequestBody ProductOrderDto dto){
		Integer result = cartService.removeProduct(dto);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}

	@ApiOperation(value="장바구니 비우기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="memberNo", value="사용자번호", required=true, dataType="long", defaultValue="")
	})
	@DeleteMapping("/{memberNo}")
	public ResponseEntity<JSONResult> removeCart(@RequestBody Long memberNo){
		Integer result = cartService.removeCart(memberNo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
}
