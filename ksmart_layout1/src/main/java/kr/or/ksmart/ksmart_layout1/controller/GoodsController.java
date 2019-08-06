package kr.or.ksmart.ksmart_layout1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.ksmart_layout1.service.GoodsService;
import kr.or.ksmart.ksmart_layout1.vo.Goods;
import kr.or.ksmart.ksmart_layout1.vo.Member;

@Controller
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	@GetMapping("/goodsList")
	public String getGoodsList(Model model) {
		
		List<Goods> list = goodsService.getGoodsList();
		
		model.addAttribute("goodsList", list);
		
		return "/goods/glist/goodsList";
	}
	
	@PostMapping("/goodsList")
	public String getGoodsSearchList(@RequestParam(value="sk")String sk
									   ,@RequestParam(value="sv")String sv
									   ,@RequestParam(value="firstMoney")String firstMoney
									   ,@RequestParam(value="lastMoney")String lastMoney
									   ,Model model) {
		List<Goods> list = goodsService.getGoodsSearchList(sk, sv, firstMoney, lastMoney);
		model.addAttribute("goodsList", list);
		
		return "/goods/glist/goodsList";
	}
	
	@GetMapping("/addGoods")
	public String addGoods() {
		
		
		
		return "/goods/gInsert/addGoods";
	}
	
	@PostMapping("/addGoods")
	public String addGoods(Goods goods, HttpSession session) {
		
		goodsService.addGoods(goods, session);
		
		return "redirect:/goodsList";
	}
	
	/*
	 * @PostMapping("/addGoods") public String addGoods(Goods goods, HttpSession
	 * session) {
	 * 
	 * goodsService.addGoods1(goods, session);
	 * 
	 * return "redirect:/goodsList"; }
	 */
	
	@GetMapping("/modifyGoods")
	public String modifyGoods(@RequestParam(value="goodsCode") String goodsCode,Model model) {
		
		model.addAttribute("goods", goodsService.getGoodsByCode(goodsCode));
		
		return "/goods/gUpdate/modifyGoods";
	}
	
	@PostMapping("/modifyGoods")
	public String modifyGoods(Goods goods) {
		System.out.println(goods.toString() + "<-- goods");
		
		goodsService.modifyGoods(goods);
		
		return "redirect:/goodsList";
	}
	
	@GetMapping("/delGoods")
	public String delGoods(@RequestParam(value="goodsCode")String goodsCode
							,@RequestParam(value="memberId")String memberId				
							,Model model) {
		
		model.addAttribute("goodsCode", goodsCode);
		model.addAttribute("memberId", memberId);
		
		return "/goods/gDelete/delGoods";
	}
	
	@PostMapping("/delGoods")
	public String delGoods(Goods goods, Member member, Model model) {
		
		int result = goodsService.delGoods(goods.getGoodsCode()
											,member.getMemberId()
											,member.getMemberPw());
		
		if(result == 0) {
			model.addAttribute("result", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("goodsCode", goods.getGoodsCode());
			model.addAttribute("memberId", member.getMemberId());
			return "/goods/gDelete/delGoods";
		}
		
		return "redirect:/goodsList";
	}
	
	
	
	
}
