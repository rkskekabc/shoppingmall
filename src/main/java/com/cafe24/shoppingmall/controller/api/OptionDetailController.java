package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.dto.OptionDetailInfoDto;
import com.cafe24.shoppingmall.service.OptionDetailService;
import com.cafe24.shoppingmall.vo.CategoryVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("optionDetailAPIController")
@RequestMapping("/api/optiondetail")
public class OptionDetailController {
	@Autowired
	private OptionDetailService optionDetailService;
	
	@ApiOperation(value="상세옵션목록")
	@GetMapping("/")
	public ResponseEntity<JSONResult> getList() {
		List<OptionDetailInfoDto> list = optionDetailService.getList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}

	@ApiOperation(value="상세옵션목록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="카테고리번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="name", value="카테고리명", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="parent_no", value="상위 카테고리 번호", required=true, dataType="long", defaultValue="")
	})
	@PostMapping("/")
	public ResponseEntity<JSONResult> add(@RequestBody CategoryVo vo) {
		//Long no = categoryService.add(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(""));
	}
}
