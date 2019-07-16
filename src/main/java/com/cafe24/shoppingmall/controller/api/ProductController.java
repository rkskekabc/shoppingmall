package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.vo.ProductVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("productAPIController")
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@ApiOperation(value="상품목록 폼 요청")
	@ApiImplicitParams({
		@ApiImplicitParam(name="categoryNo", value="카테고리번호", required=false, dataType="int", defaultValue=""),
		@ApiImplicitParam(name="searchText", value="검색어", required=false, dataType="string", defaultValue="")
	})
	@RequestMapping(value="/", method=RequestMethod.GET)
	public JSONResult productListForm(@RequestParam(value="categoryNo", required=true, defaultValue="") String categoryNo, @RequestParam(value="searchText", required=false, defaultValue="") String searchText) {
		List<ProductVo> productList = productService.getList(categoryNo, searchText);
		return JSONResult.success("a");
	}
	
	@ApiOperation(value="상품상세보기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="상품번호", required=true, dataType="string", defaultValue="")
	})
	@RequestMapping(value="/{no}", method=RequestMethod.GET)
	public JSONResult productDetail(@PathVariable String no) {
		Boolean exist = true;
		return JSONResult.success(exist);
	}
	
	@ApiOperation(value="상품등록 폼 요청")
	@ApiImplicitParams({
		@ApiImplicitParam(name="categoryNo", value="카테고리번호", required=false, dataType="int", defaultValue=""),
		@ApiImplicitParam(name="searchText", value="검색어", required=false, dataType="string", defaultValue="")
	})
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public JSONResult productInsertForm() {
		String url = "insert_form";
		return JSONResult.success(url);
	}
	
	@ApiOperation(value="상품등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="상품번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="optionNo", value="옵션번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="type", value="상품 종류", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="name", value="이름", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="explanation", value="설명", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="regDate", value="등록일", required=true, dataType="string", defaultValue="")
	})
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public JSONResult checkEmail(@RequestBody ProductVo vo) {
		Long no = productService.insert(vo);
		return JSONResult.success(no);
	}
}
