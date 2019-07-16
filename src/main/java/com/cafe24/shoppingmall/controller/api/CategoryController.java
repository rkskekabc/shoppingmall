package com.cafe24.shoppingmall.controller.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.vo.CategoryVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("categoryAPIController")
@RequestMapping("/api/category")
public class CategoryController {
	@ApiOperation(value="카테고리등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="카테고리번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="name", value="카테고리명", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="parent_no", value="상위 카테고리 번호", required=true, dataType="long", defaultValue="")
	})
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public JSONResult putCart(@RequestBody CategoryVo vo) {
		Boolean exist = true;
		return JSONResult.success(exist);
	}
}
