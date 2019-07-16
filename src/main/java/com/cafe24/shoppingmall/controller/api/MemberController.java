package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.MemberService;
import com.cafe24.shoppingmall.vo.MemberVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("memberAPIController")
@RequestMapping("/api/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@ApiOperation(value="회원가입 폼 요청")
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public JSONResult joinForm() {
		String url = "member_form";
		return JSONResult.success("member_form");
	}
	
	@ApiOperation(value="아이디 존재 여부")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id", value="아이디", required=true, dataType="string", defaultValue="")
	})
	@RequestMapping(value="/checkid", method=RequestMethod.GET)
	public JSONResult checkId(@RequestParam(value="id", required=true, defaultValue="") String id) {
		Boolean exist = memberService.existId(id);
		if(exist) {
			return JSONResult.success(exist);
		} else {
			return JSONResult.fail("not exist");
		}
	}
	
	@ApiOperation(value="이메일 존재 여부")
	@ApiImplicitParams({
		@ApiImplicitParam(name="email", value="이메일주소", required=true, dataType="string", defaultValue="")
	})
	@RequestMapping(value="/checkemail", method=RequestMethod.GET)
	public ResponseEntity<JSONResult> checkEmail(@RequestParam(value="email", required=true, defaultValue="") String email) {
		Boolean exist = memberService.existEmail(email);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(exist));
	}

	@ApiOperation(value="회원가입 처리")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id", value="아이디", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="password", value="비밀번호", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="type", value="분류", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="birth", value="생년월일", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="gender", value="성별", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="email", value="이메일", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="phone", value="연락처", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="address", value="주소", required=true, dataType="string", defaultValue="")
	})
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public ResponseEntity<JSONResult> join(@RequestBody @Valid MemberVo vo, BindingResult bindResult) {
		// ### @Valid 통과 불가할 시 error 전달
		if(bindResult.hasErrors()) {
			List<ObjectError> list = bindResult.getAllErrors();
			for(ObjectError error : list) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}
		Long no = memberService.join(vo);
        return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(no));
	}
	
	@ApiOperation(value="회원정보 수정 폼 요청")
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public JSONResult updateForm() {
		String url = "update_form";
		return JSONResult.success("update_form");
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
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public JSONResult update(@RequestBody MemberVo vo) {
		Long no = memberService.update(vo);
		return JSONResult.success(no);
	}
	
	@ApiOperation(value="로그인 폼 요청")
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public JSONResult loginForm() {
		String url = "login_form";
		return JSONResult.success(url);
	}

	@ApiOperation(value="로그인 처리 요청")
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<JSONResult> login(@RequestBody MemberVo vo) {
		Long no = memberService.login(vo);
		return no != -1L ? ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(no))
							: ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("Invalid Info"));
	}

	@ApiOperation(value="로그아웃 요청")
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public JSONResult logout() {
		return JSONResult.success("logout");
	}
}
