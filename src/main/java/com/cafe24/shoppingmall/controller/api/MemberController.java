package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.MemberService;
import com.cafe24.shoppingmall.vo.MemberVo;
import com.google.gson.Gson;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("memberAPIController")
@RequestMapping("/api/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@ApiOperation(value="아이디 존재 여부")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id", value="아이디", required=true, dataType="string", defaultValue="")
	})
	@PostMapping("/checkid")
	public ResponseEntity<JSONResult> checkId(@RequestBody MemberVo vo) {
		Boolean exist = memberService.existId(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(exist));
	}
	
	@ApiOperation(value="이메일 존재 여부")
	@ApiImplicitParams({
		@ApiImplicitParam(name="email", value="이메일주소", required=true, dataType="string", defaultValue="")
	})
	@PostMapping("/checkemail")
	public ResponseEntity<JSONResult> checkEmail(@RequestBody MemberVo vo) {
		Boolean exist = memberService.existEmail(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(exist));
	}

	@ApiOperation(value="회원가입 처리")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id", value="아이디", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="password", value="비밀번호", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="name", value="이름", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="type", value="분류", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="birth", value="생년월일", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="gender", value="성별", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="email", value="이메일", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="phone", value="연락처", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="address", value="주소", required=true, dataType="string", defaultValue="")
	})
	@PostMapping("/")
	public ResponseEntity<JSONResult> join(@RequestBody @Valid MemberVo vo, BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			List<ObjectError> list = bindResult.getAllErrors();
			for(ObjectError error : list) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}
		Long no = memberService.join(vo);
        return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(no));
	}
	
	@ApiOperation(value="회원정보 수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="회원번호", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="id", value="아이디", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="password", value="비밀번호", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="type", value="분류", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="birth", value="생년월일", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="gender", value="성별", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="email", value="이메일", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="phone", value="연락처", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="address", value="주소", required=true, dataType="string", defaultValue="")
	})
	@PutMapping("/{no}")
	public ResponseEntity<JSONResult> update(@PathVariable Long no, @RequestBody MemberVo vo) {
		Long returnNo = memberService.update(no, vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(returnNo));
	}

	@ApiOperation(value="로그인 처리 요청")
	@PostMapping("/login")
	public ResponseEntity<JSONResult> login(@RequestBody MemberVo vo) {
		MemberVo returnVo = memberService.login(vo);
		return vo != null ? ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(new Gson().toJson(returnVo)))
							: ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("Invalid Info"));
	}

	@ApiOperation(value="로그아웃 요청")
	@PostMapping("/logout")
	public ResponseEntity<JSONResult> logout() {
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("logout"));
	}
}
