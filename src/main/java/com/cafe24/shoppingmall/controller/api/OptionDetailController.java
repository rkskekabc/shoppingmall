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

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.dto.OptionDetailInfoDto;
import com.cafe24.shoppingmall.service.OptionDetailService;
import com.cafe24.shoppingmall.vo.OptionDetailVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("optionDetailAPIController")
@RequestMapping("/api/optiondetail")
public class OptionDetailController {
	@Autowired
	private OptionDetailService optionDetailService;
	
	@ApiOperation(value="상세옵션목록")
	@GetMapping("")
	public ResponseEntity<JSONResult> getList() {
		List<OptionDetailInfoDto> list = optionDetailService.getList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	@ApiOperation(value="상세옵션선택")
	@GetMapping("/{no}")
	public ResponseEntity<JSONResult> get(@PathVariable Long no) {
		OptionDetailInfoDto dto = optionDetailService.getByNo(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(dto));
	}

	@ApiOperation(value="상세옵션입력")
	@ApiImplicitParams({
		@ApiImplicitParam(name="product_no", value="상품번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="category_no", value="카테고리번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="option_child_no1", value="하위옵션 번호1", required=false, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="option_child_no2", value="하위옵션 번호2", required=false, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="stock", value="재고", required=true, dataType="int", defaultValue="")
	})
	@PostMapping("")
	public ResponseEntity<JSONResult> insert(@RequestBody OptionDetailVo vo) {
		Long no = optionDetailService.insert(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(no));
	}

	@ApiOperation(value="상세옵션수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="상세옵션번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="product_no", value="상품번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="category_no", value="카테고리번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="option_child_no1", value="하위옵션 번호1", required=false, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="option_child_no2", value="하위옵션 번호2", required=false, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="stock", value="재고", required=true, dataType="int", defaultValue="")
	})
	@PutMapping("/{no}")
	public ResponseEntity<JSONResult> update(@PathVariable Long no, @RequestBody OptionDetailVo vo) {
		Long resultNo = optionDetailService.update(no, vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(resultNo));
	}

	@ApiOperation(value="상세옵션삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="상세옵션번호", required=true, dataType="long", defaultValue=""),
	})
	@DeleteMapping("/{no}")
	public ResponseEntity<JSONResult> delete(@PathVariable Long no) {
		Boolean result = optionDetailService.delete(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
}
