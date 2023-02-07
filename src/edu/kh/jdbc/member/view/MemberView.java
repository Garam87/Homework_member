package edu.kh.jdbc.member.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.board.model.service.MemberService;
import edu.kh.jdbc.member.vo.Member;

public class MemberView {

	private Scanner sc =  new Scanner(System.in);
	
	private MemberService service = new MemberService();
	
	
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
				System.out.println("6. 뒤로 가기");
				
				System.out.print("\n 메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();
				
				switch(input) {
				case 1 : selectMyinfo(); break;
				case 2 : selectAll(); break;
				case 3 : updateMember(); break;
				case 4 : updatePw(); break;
				case 5 : secession(); break;
				case 6 : return;
				default : System.out.println("메뉴에 작성된 번호만 입력해 주세요.");
				}
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} while(input != 0);
		
	}

	private void selectMyinfo() {
		System.out.println("<내 정보 조회>");
		Member mem;
		try {
			mem = service.selectMyinfo(loginMember);
			System.out.println("회원번호 | 아이디 |  이름  | 성별 | 가입일 ");
			System.out.println("------------------------------------------------");
			System.out.printf("%8d | %4s |%4s | %2s  | %s\n\n",
					mem.getMemberNo(), mem.getMemberId(), mem.getMemberName(), mem.getMemberGender(), mem.getEnrollDate());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private void selectAll() {
		System.out.println("<회원 목록 조회>");
		List<Member> mem = new ArrayList<>();
		try {
			mem = service.selectAll(loginMember);
			System.out.println("아이디 |  이름  | 성별");
			System.out.println("--------------------------");
			
			for (Member member : mem) {
				System.out.printf("%4s | %3s | %2s\n\n",
						member.getMemberId(),
						member.getMemberName(),
						member.getMemberGender());
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
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
