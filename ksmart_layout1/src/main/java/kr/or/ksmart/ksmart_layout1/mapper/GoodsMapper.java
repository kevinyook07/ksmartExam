package kr.or.ksmart.ksmart_layout1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.ksmart_layout1.vo.Goods;

@Mapper
public interface GoodsMapper {
	
	public List<Goods> getGoodsList(); 
	
	public List<Goods> getGoodsSearchList (String sk, String sv, String firstMoney, String lastMoney);
	
	public int addGoods(Goods goods);
	
	public int addGoods1(Goods goods);
	
	public int getGoodsCodeMax();
	
	public Goods getGoodsByCode(String goodsCode);
	
	public int modifyGoods(Goods goods);
	
	public int delGoods(String goodsCode, String memberID, String memberPw);
	
}
