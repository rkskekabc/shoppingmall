package com.cafe24.shoppingmall.controller.api;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.vo.MemberVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("productAPIController")
@RequestMapping("/api/product")
public class ProductController {
	//@Autowired
	//private ProductService productService;
	
	@ApiOperation(value="상품목록 폼 요청")
	@ApiImplicitParams({
		@ApiImplicitParam(name="categoryNo", value="카테고리번호", required=false, dataType="int", defaultValue=""),
		@ApiImplicitParam(name="searchText", value="검색어", required=false, dataType="string", defaultValue="")
	})
	@RequestMapping(value="/", method=RequestMethod.GET)
	public JSONResult productListForm(@RequestParam(value="categoryNo", required=true, defaultValue="") String categoryNo, @RequestParam(value="searchText", required=false, defaultValue="") String searchText) {
		Boolean exist = true;
		return JSONResult.success(exist);
	}
	
	@ApiOperation(value="상품상세보기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="상품번호", required=true, dataType="string", defaultValue="")
	})
	@RequestMapping(value="/{no}", method=RequestMethod.GET)
	public JSONResult checkEmail(@PathVariable String no) {
		Boolean exist = true;;
		return JSONResult.success(exist);
	}
}
