package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.dto.OrderHistoryDto;
import com.cafe24.shoppingmall.dto.ProductOrderDto;
import com.cafe24.shoppingmall.service.OrderService;
import com.cafe24.shoppingmall.vo.OrderHistoryVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("orderAPIController")
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@ApiOperation(value="전체 주문내역 목록")
	@GetMapping("")
	public ResponseEntity<JSONResult> orderHistoryListAll() {
		List<OrderHistoryDto> list = orderService.getListAll();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	@ApiOperation(value="주문내역 목록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="memberNo", value="사용자번호", required=true, dataType="long", defaultValue="")
	})
	@GetMapping("/member/{memberNo}")
	public ResponseEntity<JSONResult> orderHistoryList(@PathVariable Long memberNo) {
		List<OrderHistoryVo> list = orderService.getList(memberNo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	@ApiOperation(value="주문내역")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="주문번호", required=true, dataType="long", defaultValue="")
	})
	@GetMapping("/{no}")
	public ResponseEntity<JSONResult> orderHistory(@PathVariable Long no) {
		OrderHistoryVo vo = orderService.get(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
	@ApiOperation(value="주문(장바구니)")
	@ApiImplicitParams({
		@ApiImplicitParam(name="memberNo", value="사용자번호", required=true, dataType="long", defaultValue=""),
	})
	@PostMapping("/cart/{memberNo}")
	public ResponseEntity<JSONResult> cartOrder(@PathVariable Long memberNo) {
		Boolean result = orderService.cartOrder(memberNo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}

	@ApiOperation(value="주문(상품)")
	@ApiImplicitParams({
		@ApiImplicitParam(name="memberNo", value="사용자번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="productNo", value="상품번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="num", value="개수", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="price", value="가격", required=true, dataType="long", defaultValue="")
	})
	@PostMapping("/productorder")
	public JSONResult productOrder(@RequestBody ProductOrderDto dto) {
		Boolean result = orderService.productOrder(dto);
		return JSONResult.success(result);
	}
}
