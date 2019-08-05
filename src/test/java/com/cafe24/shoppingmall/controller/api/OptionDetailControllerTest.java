package com.cafe24.shoppingmall.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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

import com.cafe24.shoppingmall.vo.CategoryVo;
import com.cafe24.shoppingmall.vo.OptionDetailVo;
import com.google.gson.Gson;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class OptionDetailControllerTest {
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
	public void testAInsertOptionDetail() throws Exception {
		OptionDetailVo vo = new OptionDetailVo();
		vo.setProductNo(1L);
		vo.setCategoryNo(1L);
		vo.setOptionChildNo1(1L);
		vo.setOptionChildNo2(2L);
		vo.setStock(100);
		
		ResultActions resultActions =
				mockMvc
					.perform(post("/api/optiondetail")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(1)));
	}
	
	@Test
	public void testBUpdateOptionDetail() throws Exception {
		OptionDetailVo vo = new OptionDetailVo();
		vo.setProductNo(1L);
		vo.setCategoryNo(1L);
		vo.setOptionChildNo1(1L);
		vo.setOptionChildNo2(2L);
		vo.setStock(200);
		
		ResultActions resultActions =
				mockMvc
					.perform(put("/api/optiondetail/1")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(1)));
	}
	
	@Test
	public void testCGetOptionDetailList() throws Exception {
		OptionDetailVo vo = new OptionDetailVo();
		vo.setProductNo(1L);
		vo.setCategoryNo(1L);
		vo.setOptionChildNo1(1L);
		vo.setOptionChildNo2(2L);
		vo.setStock(100);
		
		ResultActions resultActions =
				mockMvc
					.perform(get("/api/optiondetail")
					.contentType(MediaType.APPLICATION_JSON));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(new Gson().toJson(vo))));
	}
	
	@Test
	public void testDGetOptionDetail() throws Exception {
		OptionDetailVo vo = new OptionDetailVo();
		vo.setProductNo(1L);
		vo.setCategoryNo(1L);
		vo.setOptionChildNo1(1L);
		vo.setOptionChildNo2(2L);
		vo.setStock(100);
		
		ResultActions resultActions =
				mockMvc
					.perform(get("/api/optiondetail/1")
					.contentType(MediaType.APPLICATION_JSON));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(new Gson().toJson(vo))));
	}
	
	@Test
	public void testEDeleteOptionDetail() throws Exception {
		ResultActions resultActions =
				mockMvc
					.perform(delete("/api/optiondetail/1")
					.contentType(MediaType.APPLICATION_JSON));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(true)));
	}
}
