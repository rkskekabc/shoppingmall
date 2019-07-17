package com.cafe24.shoppingmall.controller.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.dto.ProductOrderDto;
import com.cafe24.shoppingmall.vo.CartVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("orderAPIController")
@RequestMapping("/api/order")
public class OrderController {
	//@Autowired
	//private ProductService productService;
	
	@ApiOperation(value="장바구니등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="memberNo", value="사용자번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="prodNo", value="상품번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="num", value="개수", required=true, dataType="int", defaultValue=""),
		@ApiImplicitParam(name="price", value="가격", required=true, dataType="int", defaultValue="")
	})
	@RequestMapping(value="/cart", method=RequestMethod.POST)
	public JSONResult putCart(@RequestBody CartVo vo) {
		Boolean exist = true;
		return JSONResult.success(exist);
	}
	
	@ApiOperation(value="장바구니제거")
	@ApiImplicitParams({
		@ApiImplicitParam(name="memberNo", value="사용자번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="prodNo", value="상품번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="num", value="개수", required=true, dataType="int", defaultValue=""),
		@ApiImplicitParam(name="price", value="가격", required=true, dataType="int", defaultValue="")
	})
	@RequestMapping(value="/cart/remove", method=RequestMethod.POST)
	public JSONResult removeCart(@RequestBody CartVo vo) {
		Boolean exist = true;
		return JSONResult.success(exist);
	}
	
	@ApiOperation(value="장바구니목록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="memberNo", value="사용자번호", required=true, dataType="long", defaultValue="")
	})
	@RequestMapping(value="/cart/list", method=RequestMethod.GET)
	public JSONResult cartList(@RequestBody CartVo vo) {
		Boolean exist = true;
		return JSONResult.success(exist);
	}
	
	@ApiOperation(value="주문(장바구니)")
	@ApiImplicitParams({
		@ApiImplicitParam(name="memberNo", value="사용자번호", required=true, dataType="long", defaultValue=""),
	})
	@RequestMapping(value="/cartorder", method=RequestMethod.POST)
	public JSONResult cardOrder(@RequestBody CartVo vo) {
		Boolean exist = true;
		return JSONResult.success(exist);
	}
	
	@ApiOperation(value="주문(상품)")
	@ApiImplicitParams({
		@ApiImplicitParam(name="memberNo", value="사용자번호", required=true, dataType="long", defaultValue=""),
	})
	@RequestMapping(value="/productorder", method=RequestMethod.POST)
	public JSONResult productOrder(@RequestBody ProductOrderDto dto) {
		Boolean exist = true;
		return JSONResult.success(exist);
	}
	
	@ApiOperation(value="주문내역 폼 요청")
	@RequestMapping(value="/", method=RequestMethod.GET)
	public JSONResult orderListForm() {
		Boolean exist = true;
		return JSONResult.success(exist);
	}
}
