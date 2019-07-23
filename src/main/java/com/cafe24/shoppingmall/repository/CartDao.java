package com.cafe24.shoppingmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.dto.CartProductDto;
import com.cafe24.shoppingmall.dto.ProductOrderDto;
import com.cafe24.shoppingmall.vo.CartVo;

@Repository
public class CartDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<CartProductDto> getCartList(Long memberNo){
		return sqlSession.selectList("cart.getCartList", memberNo);
	}

	public Boolean inputCart(CartVo vo) {
		sqlSession.insert("cart.insert", vo);
		return true;
	}

	public Integer updateCart(CartVo vo) {
		return sqlSession.update("cart.update", vo);
	}

	public Integer deleteOne(ProductOrderDto dto) {
		return sqlSession.delete("cart.deleteOne", dto);
	}

	public Integer deleteAll(Long memberNo) {
		return sqlSession.delete("cart.deleteAll", memberNo);
	}
}
