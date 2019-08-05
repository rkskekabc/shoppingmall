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

import com.cafe24.shoppingmall.vo.CartVo;
import com.cafe24.shoppingmall.vo.CategoryVo;
import com.google.gson.Gson;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class CartControllerTest {
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
	public void testAInsertCart() throws Exception {
		CartVo vo = new CartVo();
		vo.setMemberNo(1L);
		vo.setOptionDetailNo(1L);
		vo.setNum(10);
		vo.setPrice(300000);
		
		ResultActions resultActions =
				mockMvc
					.perform(post("/api/cart")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(true)));
	}

	@Test
	public void testBUpdateCart() throws Exception {
		CartVo vo = new CartVo();
		vo.setMemberNo(1L);
		vo.setOptionDetailNo(1L);
		vo.setNum(20);
		vo.setPrice(600000);
		
		ResultActions resultActions =
				mockMvc
					.perform(put("/api/cart")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(1)));
	}

	@Test
	public void testCGetCart() throws Exception {
		CartVo vo = new CartVo();
		vo.setMemberNo(1L);
		vo.setOptionDetailNo(1L);
		vo.setNum(20);
		vo.setPrice(600000);
		
		ResultActions resultActions =
				mockMvc
					.perform(get("/api/cart")
					.contentType(MediaType.APPLICATION_JSON));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(new Gson().toJson(vo))));
	}

	@Test
	public void testDDeleteCart() throws Exception {
		CartVo vo = new CartVo();
		vo.setMemberNo(1L);
		vo.setOptionDetailNo(1L);
		
		ResultActions resultActions =
				mockMvc
					.perform(delete("/api/cart")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(true)));
	}

	@Test
	public void testEEmptyCart() throws Exception {
		ResultActions resultActions =
				mockMvc
					.perform(delete("/api/cart/1")
					.contentType(MediaType.APPLICATION_JSON));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(true)));
	}
}
