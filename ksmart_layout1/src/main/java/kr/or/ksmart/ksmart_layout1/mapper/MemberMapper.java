package kr.or.ksmart.ksmart_layout1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.ksmart_layout1.vo.Member;

@Mapper
public interface MemberMapper {
	/* 주석
	 * @param 
	 * @return
	 * @detail
	 */
	public Member getMemberLogin(Member member);
	
	public List<Member> getMemberList();
	
	public int addMember(Member member);
	
	public Member getMemberById(String memberId);
	
	public int modifyMember(Member member);
	
	public int delMember(String memberId, String memberPw);
	
	public List<Member> getMemberSearchList (String sk, String sv);
	
	

}
