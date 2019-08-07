package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.vo.ProductVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController("productAPIController")
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@ApiOperation(value="상품목록")
	@GetMapping("")
	public ResponseEntity<JSONResult> getList() {
		List<ProductVo> list = productService.getList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	@ApiOperation(value="상품상세보기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="상품번호", required=true, dataType="long", defaultValue="")
	})
	@GetMapping(value="/{no}")
	public ResponseEntity<JSONResult> productDetail(@PathVariable Long no) {
		ProductVo vo = productService.get(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
	@ApiOperation(value="상품등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="type", value="상품 종류", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="name", value="이름", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="price", value="가격", required=true, dataType="int", defaultValue=""),
		@ApiImplicitParam(name="explanation", value="설명", required=true, dataType="string", defaultValue=""),
	})
	@PostMapping("")
	public ResponseEntity<JSONResult> productInsert(@RequestBody ProductVo vo) {
		Long no = productService.insert(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(no));
	}

	
	@ApiOperation(value="상품수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="상품번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="type", value="상품 종류", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="name", value="이름", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="price", value="가격", required=true, dataType="int", defaultValue=""),
		@ApiImplicitParam(name="explanation", value="설명", required=true, dataType="string", defaultValue=""),
	})
	@PutMapping(value="/{no}")
	public ResponseEntity<JSONResult> productUpdate(@PathVariable Long no, @RequestBody ProductVo vo) {
		Long resultNo = productService.update(no, vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(resultNo));
	}
	
	@ApiOperation(value="상품삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="상품번호", required=true, dataType="long", defaultValue="")
	})
	@DeleteMapping(value="/{no}")
	public ResponseEntity<JSONResult> productDelete(@PathVariable Long no) {
		Boolean result = productService.delete(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
}
