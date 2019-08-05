package com.cafe24.shoppingmall.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.shoppingmall.vo.MemberVo;
import com.google.gson.Gson;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MemberControllerTest {
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before	
	public void setUp() {
		mockMvc = MockMvcBuilders.
			webAppContextSetup(webApplicationContext).
			build();
	}

	@Test
	public void testAFailExistId() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setId("rkskekfk");
		
		ResultActions resultActions =
				mockMvc
					.perform(post("/api/member/checkid")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(false)));
	}
	
	@Test
	public void testBFailExistEmail() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setEmail("rkskekfk@rkskekfk.com");
		
		ResultActions resultActions =
				mockMvc
					.perform(post("/api/member/checkemail")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(false)));
	}
	
	@Test
	public void testCFailValidationJoinMember() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setId("rkskekfk");
		vo.setPassword("rkskekfk");
		vo.setName("가나다라");
		vo.setType("USER");
		vo.setBirth("2001-01-01");
		vo.setGender("m");
		vo.setEmail("rkskekfk");
		vo.setPhone("010-1111-1111");
		vo.setAddress("주소");
		
		ResultActions resultActions =
		mockMvc
		.perform(post("/api/member").contentType(MediaType.APPLICATION_JSON)
		.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isBadRequest())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("fail")))
		.andExpect(jsonPath("$.message", is("invalid email")));
	}

	@Test
	public void testDSuccessJoinMember() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setId("rkskekfk");
		vo.setPassword("rkskekfk");
		vo.setName("가나다라");
		vo.setType("USER");
		vo.setBirth("2001-01-01");
		vo.setGender("m");
		vo.setEmail("rkskekfk@rkskekfk.com");
		vo.setPhone("010-1111-1111");
		vo.setAddress("주소");
		
		ResultActions resultActions =
		mockMvc
		.perform(post("/api/member/join").contentType(MediaType.APPLICATION_JSON)
		.content(new Gson().toJson(vo)));   
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(1)));
	}
	
	@Test
	public void testESuccessExistId() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setId("rkskekfk");
		
		ResultActions resultActions =
				mockMvc
					.perform(post("/api/member/checkid")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(true)));
	}
	
	@Test
	public void testFSuccessExistEmail() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setEmail("rkskekfk@rkskekfk.com");
		
		ResultActions resultActions =
				mockMvc
					.perform(post("/api/member/checkemail")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(true)));
	}
	
	@Test
	public void testGFailUpdate() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setEmail("rkskekfk");
		
		ResultActions resultActions =
				mockMvc
					.perform(put("/api/member/1")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(-1)));
	}
	
	@Test
	public void testHSuccessUpdate() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setEmail("rkskekfk1@rkskekfk.com");
		
		ResultActions resultActions =
				mockMvc
					.perform(put("/api/member/1")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(1)));
	}

	@Test
	public void testIFailLogin() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setId("rkskekfk");
		vo.setPassword("rkskekfk123");
		
		ResultActions resultActions =
				mockMvc
					.perform(post("/api/member/login")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("fail")))
		.andExpect(jsonPath("$.message", is("Invalid Info")));
	}
	
	@Test
	public void testJSuccessLogin() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setId("rkskekfk");
		vo.setPassword("rkskekfk");
		
		ResultActions resultActions =
				mockMvc
					.perform(post("/api/member/login")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(1)));
	}
	
	@Test
	public void testKSuccsessLogout() throws Exception {
		ResultActions resultActions =
				mockMvc
					.perform(post("/api/member/logout")
					.contentType(MediaType.APPLICATION_JSON));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is("logout")));
	}
}
