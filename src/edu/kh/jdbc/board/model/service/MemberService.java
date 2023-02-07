package edu.kh.jdbc.board.model.service;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.board.model.dao.MemberDAO;
import static edu.kh.jdbc.common.JDBCTemplate.*;
import edu.kh.jdbc.member.vo.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();
	
	
	/** 내 정보 조회 서비스
	 * 
	 * @param loginMember
	 * @return mem
	 * @throws Exception
	 */
	public Member selectMyinfo(Member loginMember) throws Exception{

		Connection conn = getConnection();
		
		Member mem = dao.selectMyinfo(conn, loginMember);
		
		close(conn);
		
		return mem;
	}


	public List<Member> selectAll(Member loginMember) throws Exception{
		
		Connection conn = getConnection();
		
		List<Member> mem = dao.selectAll(conn, loginMember);
		
		close(conn);
		
		return mem;
	}

}
