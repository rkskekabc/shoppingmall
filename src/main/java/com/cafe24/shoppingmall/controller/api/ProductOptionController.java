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
import com.cafe24.shoppingmall.service.ProductOptionService;
import com.cafe24.shoppingmall.vo.OptionChildVo;
import com.cafe24.shoppingmall.vo.OptionParentVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("optionAPIController")
@RequestMapping("/api/option")
public class ProductOptionController {
	@Autowired
	private ProductOptionService productOptionService;

	@ApiOperation(value="상위옵션 가져오기")
	@GetMapping("/parent")
	public ResponseEntity<JSONResult> getParentList() {
		List<OptionParentVo> list = productOptionService.getOptionParentList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	@ApiOperation(value="상위옵션 선택")
	@GetMapping("/parent/{no}")
	public ResponseEntity<JSONResult> getParentByNo(@PathVariable Long no) {
		OptionParentVo vo = productOptionService.getOptionParentByNo(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
	@ApiOperation(value="상위옵션 입력")
	@ApiImplicitParams({
		@ApiImplicitParam(name="name", value="이름", required=true, dataType="string", defaultValue=""),
	})
	@PostMapping("/parent")
	public ResponseEntity<JSONResult> insertParent(@RequestBody OptionParentVo vo) {
		Long no = productOptionService.insertOptionParent(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(no));
	}

	@ApiOperation(value="상위옵션 변경")
	@ApiImplicitParams({
		@ApiImplicitParam(name="name", value="이름", required=true, dataType="string", defaultValue=""),
	})
	@PutMapping("/parent/{no}")
	public ResponseEntity<JSONResult> updateParent(@PathVariable Long no, @RequestBody OptionParentVo vo) {
		Long returnNo = productOptionService.updateOptionParent(no, vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(returnNo));
	}

	@ApiOperation(value="상위옵션 삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="번호", required=true, dataType="long", defaultValue="")
	})
	@DeleteMapping("/parent/{no}")
	public ResponseEntity<JSONResult> deleteParent(@PathVariable Long no) {
		Boolean result = productOptionService.deleteOptionParent(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value="하위옵션 가져오기")
	@GetMapping("/child")
	public ResponseEntity<JSONResult> getChildList() {
		List<OptionChildVo> list = productOptionService.getOptionChildList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	@ApiOperation(value="상위옵션에 달린 하위옵션 가져오기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="optionParentNo", value="상위옵션 번호", required=true, dataType="long", defaultValue="")
	})
	@GetMapping("/child/parent/{optionParentNo}")
	public ResponseEntity<JSONResult> getChildListWithParent(@PathVariable Long optionParentNo) {
		List<OptionParentVo> list = productOptionService.getOptionChildWithParentList(optionParentNo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	@ApiOperation(value="하위옵션 입력")
	@ApiImplicitParams({
		@ApiImplicitParam(name="optionParentNo", value="상위옵션 번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="name", value="이름", required=true, dataType="string", defaultValue="")
	})
	@PostMapping("/child")
	public ResponseEntity<JSONResult> insert(@RequestBody OptionChildVo vo) {
		Long no = productOptionService.insertOptionChild(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(no));
	}

	@ApiOperation(value="하위옵션 변경")
	@ApiImplicitParams({
		@ApiImplicitParam(name="optionParentNo", value="상위옵션 번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="name", value="이름", required=true, dataType="string", defaultValue="")
	})
	@PutMapping("/child/{no}")
	public ResponseEntity<JSONResult> update(@PathVariable Long no, @RequestBody OptionChildVo vo) {
		Long returnNo = productOptionService.updateOptionChild(no, vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(returnNo));
	}

	@ApiOperation(value="하위옵션 삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="번호", required=true, dataType="long", defaultValue="")
	})
	@DeleteMapping("/child/{no}")
	public ResponseEntity<JSONResult> delete(@PathVariable Long no) {
		Boolean result = productOptionService.deleteOptionChild(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
}
