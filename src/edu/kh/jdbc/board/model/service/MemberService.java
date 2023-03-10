package edu.kh.jdbc.board.model.service;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.board.model.dao.MemberDAO;
import static edu.kh.jdbc.common.JDBCTemplate.*;
import edu.kh.jdbc.member.vo.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();
	
	
	/** 회원 목록 조회 서비스
	 * 
	 * @param loginMember
	 * @return mem
	 * @throws Exception
	 */
	public List<Member> selectAll(Member loginMember) throws Exception{
		
		Connection conn = getConnection(); // 커넥션 생성
		
		// DAO 메서드 호출 후 결과 반환 받기
		List<Member> mem = dao.selectAll(conn);
		
		close(conn); // 커넥션 반환
		
		return mem;
	}


	/** 회원 정보 수정 서비스 
	 * 
	 * @param member
	 * @return
	 */
	public int updateMember(Member member) throws Exception{
		// 커넥션 생성
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn, member);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 비밀번호 변경 서비스
	 * 
	 * @param currentPw
	 * @param newPw1
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public int updatePw(String currentPw, String newPw1, int memberNo) throws Exception{

		Connection conn = getConnection();
		
		int result = dao.updatePw(conn, currentPw, newPw1, memberNo);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}


	public int secession(String memberPw, int memberNo) throws Exception{

		Connection conn = getConnection();
		
		int result = dao.secession(conn, memberPw, memberNo);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

}
