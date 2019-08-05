package com.cafe24.shoppingmall.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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

import com.cafe24.shoppingmall.vo.OptionChildVo;
import com.cafe24.shoppingmall.vo.OptionParentVo;
import com.google.gson.Gson;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ProductOptionControllerTest {
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
	public void testAInsertParentOption() throws Exception {
		OptionParentVo vo = new OptionParentVo();
		vo.setName("상위옵션1");
		
		ResultActions resultActions =
				mockMvc
					.perform(post("/api/option/parent")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(1)));
	}

	@Test
	public void testBUpdateParentOption() throws Exception {
		OptionParentVo vo = new OptionParentVo();
		vo.setName("상위옵션11");
		
		ResultActions resultActions =
				mockMvc
					.perform(put("/api/option/parent/1")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(1)));
	}

	@Test
	public void testCGetParentOption() throws Exception {
		OptionParentVo vo = new OptionParentVo();
		vo.setName("상위옵션11");
		
		ResultActions resultActions =
				mockMvc
					.perform(get("/api/option/parent")
					.contentType(MediaType.APPLICATION_JSON));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(new Gson().toJson(vo))));
	}

	@Test
	public void testDInsertChildOption() throws Exception {
		OptionChildVo vo = new OptionChildVo();
		vo.setName("하위옵션1");
		vo.setOptionParentNo(1L);
		
		ResultActions resultActions =
				mockMvc
					.perform(post("/api/option/child")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(1)));
	}

	@Test
	public void testEUpdateChildOption() throws Exception {
		OptionChildVo vo = new OptionChildVo();
		vo.setName("하위옵션11");
		
		ResultActions resultActions =
				mockMvc
					.perform(put("/api/option/child/1")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(vo)));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(1)));
	}

	@Test
	public void testFGetChildOption() throws Exception {
		OptionChildVo vo = new OptionChildVo();
		vo.setName("하위옵션11");
		vo.setOptionParentNo(1L);
		
		ResultActions resultActions =
				mockMvc
					.perform(get("/api/option/child/1")
					.contentType(MediaType.APPLICATION_JSON));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(new Gson().toJson(vo))));
	}

	@Test
	public void testGGetParentChildOption() throws Exception {
		OptionChildVo vo = new OptionChildVo();
		vo.setName("하위옵션11");
		vo.setOptionParentNo(1L);
		
		ResultActions resultActions =
				mockMvc
					.perform(get("/api/option/child/parent/1")
					.contentType(MediaType.APPLICATION_JSON));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(new Gson().toJson(vo))));
	}

	@Test
	public void testHDeleteChildOption() throws Exception {
		ResultActions resultActions =
				mockMvc
					.perform(delete("/api/option/child/1")
					.contentType(MediaType.APPLICATION_JSON));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(true)));
	}
	
	@Test
	public void testIDeleteParentOption() throws Exception {
		ResultActions resultActions =
				mockMvc
					.perform(delete("/api/option/parent/1")
					.contentType(MediaType.APPLICATION_JSON));
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(true)));
	}
}
