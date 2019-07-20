package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.OrderDao;
import com.cafe24.shoppingmall.vo.OrderHistoryVo;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;

	public List<OrderHistoryVo> getList() {
		return orderDao.getList();
	}

	public OrderHistoryVo get(Long no) {
		return orderDao.get(no);
	}

	public Long cartOrder(Long memberNo) {
		return null;
	}
	
	public Long insert() {
		return null;
	}
}
