package kr.or.ksmart.ksmart_layout1.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.ksmart_layout1.mapper.GoodsMapper;
import kr.or.ksmart.ksmart_layout1.mapper.MemberMapper;
import kr.or.ksmart.ksmart_layout1.vo.Goods;

@Service
@Transactional
public class GoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Autowired
	private MemberMapper memberMapper;
	
	public List<Goods> getGoodsList(){
		List<Goods> list = goodsMapper.getGoodsList();
		return list;
	}
	
	public List<Goods> getGoodsSearchList(String sk, String sv, String firstMoney, String lastMoney) {
		List<Goods> list = goodsMapper.getGoodsSearchList(sk, sv, firstMoney, lastMoney);
		return list;
	}
	
	public int addGoods(Goods goods, HttpSession session) {
		int max = goodsMapper.getGoodsCodeMax()+1;
		String tempCode = "goods_";
		
		goods.setMemberId((String) session.getAttribute("SID"));
		goods.setGoodsCode(tempCode+max);
		
		return goodsMapper.addGoods(goods);
	}
	
	public int addGoods1(Goods goods, HttpSession session) {
		
		goods.setMemberId((String) session.getAttribute("SID"));
		
		return goodsMapper.addGoods1(goods);
	}
	
	public Goods getGoodsByCode(String goodsCode) {
		
		return goodsMapper.getGoodsByCode(goodsCode);
	}
	
	public int modifyGoods(Goods goods) {
		
		return goodsMapper.modifyGoods(goods);
	}
	
	public int delGoods(String goodsCode, String memberID, String memberPw) {
		return goodsMapper.delGoods(goodsCode,memberID,memberPw);
	}
	
	
	
	
	
}
