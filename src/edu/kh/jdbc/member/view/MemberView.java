package edu.kh.jdbc.member.view;

import java.util.Scanner;

import edu.kh.jdbc.member.vo.Member;

public class MemberView {

	private Scanner sc =  new Scanner(System.in);
	
	// 로그인 회원 정보 저장용 변수
	private Member loginMember = null;

	public void memberMenu(Member loginMember) {
		// 전달 받은 로그인 회원 정보를 필드에 저장
		this.loginMember = loginMember;
		
		int input = -1;
		
		do {
			try {
				System.out.println("****** 회원 기능 ******");
				System.out.println("1. 내 정보 조회");
				 // 1. 내 정보 조회
				System.out.println("2. 회원 목록 조회");
				 // 2. 회원 목록 조회(아이디, 이름, 성별)
				System.out.println("3. 내 정보 수정");
				 // 3. 내 정보 수정(이름, 성별)
				System.out.println("4. 비밀번호 변경");
				 // 4. 비밀번호 변경(현재 비밀번호, 새 비밀번호, 새 비밀번호 확인)
				System.out.println("5. 회원 탈퇴");
				 // 5. 회원 탈퇴
				System.out.print("\n 메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();
				
				switch(input) {
				case 1 : selectMyinfo(); break;
				case 2 : selectAll(); break;
				case 3 : updateMember(); break;
				case 4 : updatePw(); break;
				case 5 : secession(); break;
				default : System.out.println("메뉴에 작성된 번호만 입력해 주세요.");
				}
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} while(input != 0);
		
	}

	private void selectMyinfo() {
		// TODO Auto-generated method stub
		
	}

	
	private void selectAll() {
		// TODO Auto-generated method stub
		
	}

	
	private void updateMember() {
		// TODO Auto-generated method stub
		
	}

	
	private void updatePw() {
		// TODO Auto-generated method stub
		
	}
	
	
	private void secession() {
		// TODO Auto-generated method stub
		
	}





}
