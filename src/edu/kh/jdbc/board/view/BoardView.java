package edu.kh.jdbc.board.view;

import java.util.Scanner;

public class BoardView {
	private Scanner sc =  new Scanner(System.in);

	public void boardMenu() {
		
		int input = -1;
		
		do {
			try {
				System.out.println("****** 게시판 기능 ******");
			
				System.out.println("1. 게시글 목록 조회");
				//1. 게시글 목록 조회(작성일 내림차순)
				// 	  (게시글 번호, 제목[댓글 수], 작성자명, 작성일, 조회수 )
				System.out.println("2. 게시글 상세 조회");
				// 2. 게시글 상세 조회(게시글 번호 입력 받음)
				//    (게시글 번호, 제목, 내용, 작성자명, 작성일, 조회수, 
				//     댓글 목록(작성일 오름차순 )
				//     
				//     2-1. 댓글 작성
				//     2-2. 댓글 수정 (자신의 댓글만)
				//     2-3. 댓글 삭제 (자신의 댓글만)
				// 
						// 자신이 작성한 글 일때만 메뉴 노출
				//    2-4. 게시글 수정
				//     2-5. 게시글 삭제
				System.out.println("3. 게시글 작성");      
				// 3. 게시글 작성(제목, 내용 INSERT) 
				// 	-> 작성 성공 시 상세 조회 수행
				System.out.println("4. 게시글 검색");
				// 4. 게시글 검색(제목, 내용, 제목+내용, 작성자)
				System.out.print("\n 메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();
				
				switch(input) {
				case 1 : selectAllBoard(); break;
				case 2 : selectBoard(); break;
				case 3 : insertBoard(); break;
				case 4 : searchBoard(); break;
				default : System.out.println("메뉴에 작성된 번호만 입력해 주세요.");
				}
				
				
				
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} while(input != 0);
		
		
		
	}

	private void selectAllBoard() {
		// TODO Auto-generated method stub
		
	}

	private void selectBoard() {
		// TODO Auto-generated method stub
		
	}

	private void insertBoard() {
		// TODO Auto-generated method stub
		
	}

	private void searchBoard() {
		// TODO Auto-generated method stub
		
	}

}

