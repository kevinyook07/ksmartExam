package kr.or.ksmart.ksmart_layout1.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.ksmart_layout1.mapper.MemberMapper;
import kr.or.ksmart.ksmart_layout1.vo.Member;

@Service
@Transactional
//트랜잭션과 ACID 알아보기
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	
	public Map<String, Object> getMemberLogin(Member member) {//getMemberLogin-메서드 // Member클래스 안에 member객체 참조변수
		//Map date type으로  String과 Object의 모든 객체를 담기 위해서 선언한다.
		//getMemberLogin 메서드를 선언한다.
		//Member class안에 member 객체 참조변수를 선언한다.
		
		//결과값을 서비스단에서 반환하기 위해서 String으로 선언
		//result 값을 공백으로 해놔야 String date type으로 선언된 result 객체안에 담을 수 있다.
		String result = "";
		
		//Map클래스 데이터 타입으로 map 객체참조변수를 선언하고 HashMap 생성자 메서드로 새로운 객체를 생성하고 생성한 객체의 주소값을 map객체참조변수에 할당한다.
		Map<String, Object> map = new HashMap<String,Object>();
		//결과값
		//쿼리실행된 결과
		
		//Member 클래스 데이터 타입으로 memberCheck 객체참조변수를 선언하고
		//memberMapper 클래스 내에 getMemberLogin의 member 주소 값을 memberCheck객체 참조변수에 할당한다.
		Member memberCheck = memberMapper.getMemberLogin(member);
		
		//조건문
		//member에 정보가 담기면 result = "로그인 성공"
		
		//조건문을 controller단이나 service단에 써줘도 되는데 기능적인 면이 있어서 service단에 조건문을 써준것이다.
		if(memberCheck == null) {
			
			Member memberIdCheck = memberMapper.getMemberById(member.getMemberId());
			if(memberIdCheck == null) {//만약에 id 체크하는 메서드
				result = "등록된 아이디 정보가 없습니다.";
			}else {//else result 값을 각각 다르게 처리
				result = "비밀번호가 일치하지 않습니다.";
			}
			
		}else {
			result = "로그인 성공";
			map.put("loginMember", memberCheck);
		}
		
		map.put("result", result);
		
		return map;
	}
	
	public List<Member> getMemberList(){
		List<Member> list = memberMapper.getMemberList();
		
		 
		
		return list;
	}
	
	public List<Member> getMemberSearchList(String sk, String sv) {
		List<Member> list = memberMapper.getMemberSearchList(sk, sv);
		
		return list;
	}
	
	public int addMember(Member member) {
		int result = memberMapper.addMember(member);
		return result;
	}
	
	public Member getMemberById(String memberId) {
		
		return memberMapper.getMemberById(memberId);
	}
	
	public int modifyMember(Member member) {
		int result = memberMapper.modifyMember(member);
		return result;
	}
	
	public int delMember(String memberId, String memberPw) {
		
		return memberMapper.delMember(memberId, memberPw);
	}
	
	
}
