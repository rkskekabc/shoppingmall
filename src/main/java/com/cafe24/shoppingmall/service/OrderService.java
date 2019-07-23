package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.dto.ProductOrderDto;
import com.cafe24.shoppingmall.repository.CartDao;
import com.cafe24.shoppingmall.repository.HistoryProductDao;
import com.cafe24.shoppingmall.repository.MemberDao;
import com.cafe24.shoppingmall.repository.OrderDao;
import com.cafe24.shoppingmall.vo.CartVo;
import com.cafe24.shoppingmall.vo.HistoryProductVo;
import com.cafe24.shoppingmall.vo.MemberVo;
import com.cafe24.shoppingmall.vo.OrderHistoryVo;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private HistoryProductDao historyProductDao;

	public List<OrderHistoryVo> getList(Long memberNo) {
		return orderDao.getList(memberNo);
	}

	public OrderHistoryVo get(Long no) {
		return orderDao.get(no);
	}

	public Boolean cartOrder(Long memberNo) {
		MemberVo vo = new MemberVo();
		vo.setNo(memberNo);
		
		MemberVo memberVo = memberDao.getByNo(vo);
		List<CartVo> cartList = cartDao.getCartList(memberNo);
		
		OrderHistoryVo orderHistoryVo = new OrderHistoryVo();
		orderHistoryVo.setMemberNo(memberNo);
		orderHistoryVo.setStatus("주문완료");
		orderHistoryVo.setDestination(memberVo.getAddress());
		orderHistoryVo.setPhone(memberVo.getPhone());
		
		orderDao.insert(orderHistoryVo);
		
		for(CartVo cartVo : cartList) {
			HistoryProductVo historyProductVo = new HistoryProductVo();
			historyProductVo.setHistoryNo(orderHistoryVo.getNo());
			historyProductVo.setProductNo(cartVo.getProductNo());
			historyProductVo.setNum(cartVo.getNum());
			historyProductVo.setPrice(cartVo.getPrice());
			
			historyProductDao.insert(historyProductVo);
		}
		
		return true;
	}

	public Boolean productOrder(ProductOrderDto dto) {
		MemberVo vo = new MemberVo();
		vo.setNo(dto.getMemberNo());
		
		MemberVo memberVo = memberDao.getByNo(vo);
		
		OrderHistoryVo orderHistoryVo = new OrderHistoryVo();
		orderHistoryVo.setMemberNo(dto.getMemberNo());
		orderHistoryVo.setStatus("주문완료");
		orderHistoryVo.setDestination(memberVo.getAddress());
		orderHistoryVo.setPhone(memberVo.getPhone());
		
		orderDao.insert(orderHistoryVo);
		
		HistoryProductVo historyProductVo = new HistoryProductVo();
		historyProductVo.setHistoryNo(orderHistoryVo.getNo());
		historyProductVo.setProductNo(dto.getProductNo());
		historyProductVo.setNum(dto.getNum());
		historyProductVo.setPrice(dto.getPrice());
		
		historyProductDao.insert(historyProductVo);
		
		return true;
	}
}
