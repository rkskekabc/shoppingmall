package com.cafe24.shoppingmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.CategoryService;
import com.cafe24.shoppingmall.vo.CategoryVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("categoryAPIController")
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@ApiOperation(value="카테고리등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="카테고리번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="name", value="카테고리명", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="parent_no", value="상위 카테고리 번호", required=true, dataType="long", defaultValue="")
	})
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public ResponseEntity<JSONResult> add(@RequestBody CategoryVo vo) {
		Long no = categoryService.add(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(no));
	}
	
	@ApiOperation(value="카테고리수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="카테고리번호", required=true, dataType="long", defaultValue="")
	})
	@RequestMapping(value="/update/{no}", method=RequestMethod.POST)
	public ResponseEntity<JSONResult> update(@PathVariable Long no, @RequestBody CategoryVo vo) {
		Long returnNo = categoryService.update(no, vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(returnNo));
	}
	
	@ApiOperation(value="카테고리삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="카테고리번호", required=true, dataType="long", defaultValue="")
	})
	@RequestMapping(value="/delete/{no}", method=RequestMethod.POST)
	public ResponseEntity<JSONResult> delete(@PathVariable Long no) {
		Boolean result = categoryService.delete(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
}
