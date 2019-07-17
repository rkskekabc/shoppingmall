package com.cafe24.shoppingmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.ProductOptionService;
import com.cafe24.shoppingmall.vo.ProductOptionVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("optionAPIController")
@RequestMapping("/api/option")
public class ProductOptionController {
	@Autowired
	private ProductOptionService productOptionService;

	@ApiOperation(value="상품옵션 입력")
	@ApiImplicitParams({
		@ApiImplicitParam(name="info", value="상품속성 정보", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="price", value="가격", required=true, dataType="int", defaultValue=""),
		@ApiImplicitParam(name="stock", value="재고", required=true, dataType="int", defaultValue="")
	})
	@PostMapping("/insert")
	public JSONResult insert(@RequestBody ProductOptionVo vo) {
		Long no = productOptionService.insert(vo);
		return JSONResult.success(no);
	}

	@ApiOperation(value="상품옵션 변경")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="상품속성 번호", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="info", value="상품속성 정보", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="price", value="가격", required=true, dataType="int", defaultValue=""),
		@ApiImplicitParam(name="stock", value="재고", required=true, dataType="int", defaultValue="")
	})
	@PostMapping("/update")
	public JSONResult update(@RequestBody ProductOptionVo vo) {
		Long no = productOptionService.update(vo);
		return JSONResult.success(no);
	}

	@ApiOperation(value="상품옵션 삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="상품속성 번호", required=true, dataType="string", defaultValue="")
	})
	@PostMapping("/delete/{no}")
	public JSONResult delete(@PathVariable Long no) {
		Boolean result = productOptionService.delete(no);
		return JSONResult.success(result);
	}
}
