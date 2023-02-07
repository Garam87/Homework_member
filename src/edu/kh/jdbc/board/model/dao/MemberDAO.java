package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.member.vo.Member;


public class MemberDAO {
	
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Properties prop = null;
	
	public MemberDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("member-query.xml"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 내 정보 조회 DAO
	 * 
	 * @param conn
	 * @param loginMember
	 * @return mem
	 * @throws Exception
	 */
	public Member selectMyinfo(Connection conn, Member loginMember) throws Exception {
		Member mem = new Member();
		
		try {
			
			String sql = prop.getProperty("MySelect");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginMember.getMemberId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mem = new Member(rs.getInt("MEMBER_NO"),
						rs.getString("MEMBER_ID"),
						rs.getString("MEMBER_NM"),
						rs.getString("MEMBER_GENDER"),
						rs.getString("ENROLL_DATE"));
			}
			
		} finally {
			close(stmt);
			close(rs);
		}
		
		return mem;
	}

	/** 모든 회원 정보 조회 DAO 
	 * 
	 * @param conn
	 * @param loginMember
	 * @return mem
	 * @throws Exception
	 */
	public List<Member> selectAll(Connection conn, Member loginMember) throws Exception {
		List<Member> mem = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("selectAll");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String memberId = rs.getString("MEMBER_ID");
				String memberName = rs.getString("MEMBER_NM");
				String memberGender = rs.getString("MEMBER_GENDER");
				
				Member member = new Member(memberId, memberName, memberGender);
				
				mem.add(member);
			}
			
		} finally {
			close(stmt);
			close(rs);
		}
		
		return mem;
	}
}
