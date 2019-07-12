package com.cafe24.shoppingmall.controller.api;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.shoppingmall.vo.MemberVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
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
	public void testFetchMemberList() throws Exception {
		ResultActions resultActions =
		mockMvc
		.perform(get("/api/member/join").contentType(MediaType.APPLICATION_JSON));
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", hasSize(1)))
		.andExpect(jsonPath("$.data[0].id", is("user1")))
		.andExpect(jsonPath("$.data[0].password", is("1234")))
		.andExpect(jsonPath("$.data[0].type", is("USER")))
		.andExpect(jsonPath("$.data[0].birth", is("1995-03-12")))
		.andExpect(jsonPath("$.data[0].gender", is("male")))
		.andExpect(jsonPath("$.data[0].email", is("user1@user1.com")))
		.andExpect(jsonPath("$.data[0].phone", is("010-1111-1111")))
		.andExpect(jsonPath("$.data[0].address", is("지구")))
		.andExpect(jsonPath("$.data[0].joindate", is("2019-07-12")));
	}

	@Test
	public void testInsertGuestbook() throws Exception {
		MemberVo vo = new MemberVo(); 
		vo.setId("user1");
		vo.setPassword("1234");
		vo.setType("USER");
		vo.setBirth("1995-03-12");
		vo.setGender("male");
		vo.setEmail("user1@user1.com");
		vo.setPhone("010-1111-1111");
		vo.setAddress("지구");
		vo.setJoinDate("2019-07-12");
			
		// MailSender mailSender = Mockito.mock(MailSender.class);
		// Mockito.when(mailSenderMock.sendMail("", "")).thenReturn(true);
		// isSuccess = mailSenderMock.sendMail("");
		
		ResultActions resultActions =
		mockMvc
		.perform(post("/api/member/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.id", is(vo.getId())))
		.andExpect(jsonPath("$.data.password", is(vo.getPassword())))
		.andExpect(jsonPath("$.data.type", is(vo.getType())))
		.andExpect(jsonPath("$.data.birth", is(vo.getBirth())))
		.andExpect(jsonPath("$.data.gender", is(vo.getGender())))
		.andExpect(jsonPath("$.data.email", is(vo.getEmail())))
		.andExpect(jsonPath("$.data.phone", is(vo.getPhone())))
		.andExpect(jsonPath("$.data.address", is(vo.getAddress())))
		.andExpect(jsonPath("$.data.joindate", is(vo.getJoinDate())));
	}
}
