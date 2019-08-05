package com.cafe24.shoppingmall.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.cafe24.shoppingmall.dto.ProductOrderDto;
import com.cafe24.shoppingmall.vo.OrderHistoryVo;
import com.google.gson.Gson;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class OrderControllerTest {
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
	public void testAOrderCart() throws Exception {
		ResultActions resultActions =
				mockMvc
					.perform(post("/api/order/cart/1")
					.contentType(MediaType.APPLICATION_JSON));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(true)));
	}

	@Test
	public void testBOrderProduct() throws Exception {
		ProductOrderDto dto = new ProductOrderDto();
		dto.setMemberNo(1L);
		dto.setOptionDetailNo(1L);
		dto.setNum(10);
		dto.setPrice(300000);
		
		ResultActions resultActions =
				mockMvc
					.perform(post("/api/order/productorder")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(dto)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(true)));
	}

	@Test
	public void testCGetProductList() throws Exception {
		OrderHistoryVo vo = new OrderHistoryVo();
		vo.setNo(1L);
		vo.setMemberNo(1L);
		vo.setStatus("주문완료");
		vo.setPhone("010-1111-1111");
		vo.setDestination("주소");
		
		ResultActions resultActions =
				mockMvc
					.perform(get("/api/order/member/1")
					.contentType(MediaType.APPLICATION_JSON));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(new Gson().toJson(vo))));
	}

	@Test
	public void testDGetProduct() throws Exception {
		OrderHistoryVo vo = new OrderHistoryVo();
		vo.setNo(1L);
		vo.setMemberNo(1L);
		vo.setStatus("주문완료");
		vo.setPhone("010-1111-1111");
		vo.setDestination("주소");
		
		ResultActions resultActions =
				mockMvc
					.perform(get("/api/order/1")
					.contentType(MediaType.APPLICATION_JSON));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(new Gson().toJson(vo))));
	}
}
