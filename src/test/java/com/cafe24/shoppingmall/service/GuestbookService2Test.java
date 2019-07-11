package com.cafe24.shoppingmall.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cafe24.shoppingmall.vo.MemberVo;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class GuestbookService2Test {
	
	@Autowired
	private MemberService memberService;
	
	@Test
	public void testGuestbookServiceDI() {
		assertNotNull(memberService);
	}
	
	@Test
	public void testGetContentList() {
		List<MemberVo> list;
		//assertArrayEquals(list)
	}

	@Test
	public void testWriteContent() {
		MemberVo vo = new MemberVo(); 
		//guestbookService.writeContent(vo);
	}
	
//	@AfterClass
//	public void cleanUp() {
//		guestbookDao.deleteAll();
//	}
	
}
