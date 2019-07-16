package com.cafe24.shoppingmall.controller.api;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.config.web.TestWebConfig;
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
	public void testSuccessJoinForm() throws Exception {
		ResultActions resultActions =
		mockMvc
		.perform(get("/api/member/join").contentType(MediaType.APPLICATION_JSON));
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is("member_form")));
	}
	
	@Test
	public void testSuccessJoinMember() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setEmail("KSJ@ss.com");
		vo.setPassword("1234");
		
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
	public void testFailValidationJoinMember() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setEmail("KSJ");
		vo.setPassword("1234");
		
		ResultActions resultActions =
		mockMvc
		.perform(post("/api/member/join").contentType(MediaType.APPLICATION_JSON)
		.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isBadRequest())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("fail")))
		.andExpect(jsonPath("$.message", is("invalid email")));
	}
	
	@Test
	public void testSuccessExistEmail() throws Exception {
		String email = "rkskek@rkskek.com";
		
		ResultActions resultActions =
				mockMvc
					.perform(get("/api/member/checkemail").param("email", email)
					.contentType(MediaType.APPLICATION_JSON));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(true)));
	}
	
	@Test
	public void testFailExistEmail() throws Exception {
		String email = "aaa@aaa.com";
		
		ResultActions resultActions =
				mockMvc
					.perform(get("/api/member/checkemail").param("email", email)
					.contentType(MediaType.APPLICATION_JSON));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(false)));
	}
	
	@Test
	public void testSuccessExistId() throws Exception {
		String id = "rkskek";
		
		ResultActions resultActions =
				mockMvc
					.perform(get("/api/member/checkid").param("id", id)
					.contentType(MediaType.APPLICATION_JSON));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(true)));
	}
	
	@Test
	public void testFailExistId() throws Exception {
		String id = "aaa";
		
		ResultActions resultActions =
				mockMvc
					.perform(get("/api/member/checkid").param("id", id)
					.contentType(MediaType.APPLICATION_JSON));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(false)));
	}
	
	@Test
	public void testSuccessLogin() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setId("rkskek");
		vo.setPassword("1234");
		
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
	public void testFailLogin() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setId("rksk");
		vo.setPassword("123");
		
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
	public void testSuccessUpdateForm() throws Exception {
		ResultActions resultActions =
		mockMvc
		.perform(get("/api/member/update").contentType(MediaType.APPLICATION_JSON));
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is("update_form")));
	}
	
	@Test
	public void testSuccessUpdate() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setNo(1L);
		vo.setId("rksk");
		vo.setPassword("123");
		
		ResultActions resultActions =
				mockMvc
					.perform(post("/api/member/update")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(1)));
	}
	
	@Test
	public void testFailUpdate() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setNo(2L);
		vo.setId("rksk");
		vo.setPassword("123");
		
		ResultActions resultActions =
				mockMvc
					.perform(post("/api/member/update")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(-1)));
	}
	
	@Test
	public void testSuccsessLogout() throws Exception {
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
