package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.board.model.dao.BoardDAO;
import edu.kh.jdbc.board.model.vo.Board;

public class BoardService {
	
	private BoardDAO dao = new BoardDAO();
	

	public List<Board> selectAllBoard() throws Exception{
		Connection conn = getConnection();
		
		//DAO 메서드 호출 후 결과 반환 받기
		List<Board> boardList = dao.selectAllBoard(conn);
		
		
		close(conn);
		
		return boardList;
	}


	public int insertBoard(Board board) {
		Connection conn = getConnection();
		
		
		// 게시글 번호 생성 dao 호출
		// 왜? 동시에 여러 사람이 게시글을 등록하면
		// 시퀀스가 한번에 증가하여 CURRVAL 구문을 이용하면 문제 발생
		// -> 게시글 등록 서비스를 호출한 순서대로
		// 미리 게시글 번호를 생성해서 얻어온 다음 이를 이용해 insert 진행
		int boardNo = dao.nextBoardNo(conn);
		
		close(conn);
		return 0;
	}

}
