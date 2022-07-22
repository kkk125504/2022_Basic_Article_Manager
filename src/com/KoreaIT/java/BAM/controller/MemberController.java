package com.KoreaIT.java.BAM.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.BAM.dto.Article;
import com.KoreaIT.java.BAM.dto.Member;
import com.KoreaIT.java.BAM.util.Util;

public class MemberController extends Controller {
	private Scanner sc;
	private List<Member> members;
	private String cmd;
	private String actionMethodName;
	private Member loginedMember;

	public MemberController(Scanner sc) {
		this.sc = sc;
		members = new ArrayList<>();
	}

	public void doAction(String cmd, String actionMethodName) {
		this.cmd = cmd;
		this.actionMethodName = actionMethodName;

		switch (actionMethodName) {
		case "join":
			doJoin();
			break;
		case "login":
			doLogin();
			break;
		default:
			System.out.println("존재하지 않는 명령어입니다.");
			break;
		}
	}

	private void doLogin() {

		System.out.printf("아이디 : ");
		String loginId = sc.nextLine();
		System.out.printf("비밀번호 : ");
		String loginPw = sc.nextLine();

		Member member = getMemberByloginId(loginId);

		if (member == null) {
			System.out.println("일치하는 회원이 없습니다.");
			return;
		}
		System.out.println(member.loginPw);
		if (member.loginPw.equals(loginPw) == false) {
			System.out.println("비밀번호 다시 입력해주세요");
			return;
		}
		
		loginedMember = member;
		System.out.printf("로그인 성공! %s님 환영합니다.\n", loginedMember.name);
		
	}

	public void doJoin() {
		int id = members.size() + 1;
		String regDate = Util.getNowDateStr();
		String loginId = null;
		while (true) {
			System.out.printf("로그인 아이디 : ");
			loginId = sc.nextLine();
			if (isJoinableLoginId(loginId) == false) {
				System.out.printf("%s은(는) 이미 사용중인 아이디입니다\n", loginId);
				continue;
			}
			break;
		}
		String loginPw = null;
		String loginPwConfirm = null;
		while (true) {
			System.out.printf("로그인 비밀번호 : ");
			loginPw = sc.nextLine();
			System.out.printf("로그인 비밀번호 확인 : ");
			loginPwConfirm = sc.nextLine();
			if (loginPw.equals(loginPwConfirm) == false) {
				System.out.println("비밀번호를 다시 입력해주세요");
				continue;
			}
			break;
		}
		System.out.printf("이름 : ");
		String name = sc.nextLine();
		Member member = new Member(id, regDate, loginId, loginPw, name);
		members.add(member);
		System.out.printf("%d번 회원님 환영합니다\n", id);
	}

	private boolean isJoinableLoginId(String loginId) {
		int index = getMemberIndexByLoginId(loginId);
		if (index == -1) {
			return true;
		}
		return false;
	}

	private int getMemberIndexByLoginId(String loginId) {
		int i = 0;
		for (Member member : members) {
			if (member.loginId.equals(loginId)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	private Member getMemberByloginId(String loginId) {

		int i = getMemberIndexByLoginId(loginId);

		if (i == -1) {
			return null;
		}
		return members.get(i);
	}

	private boolean isLogined() {
		if (loginedMember == null) {
			return true;
		}
		return false;
	}

	public void makeTestData() {
		System.out.println("테스트를 위한 게시물 데이터를 생성합니다.");
		members.add(new Member(1, Util.getNowDateStr(), "test1", "1111", "회원1"));
		members.add(new Member(2, Util.getNowDateStr(), "test2", "2222", "회원2"));
		members.add(new Member(3, Util.getNowDateStr(), "test3", "3333", "회원3"));
	}
}