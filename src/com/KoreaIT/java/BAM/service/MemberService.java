package com.KoreaIT.java.BAM.service;

import java.util.List;

import com.KoreaIT.java.BAM.container.Container;
import com.KoreaIT.java.BAM.dto.Member;

public class MemberService {
	public List<Member> getForPrintMembers() {
		List<Member> members = Container.memberDao.members;
		return members;
	}

	public Member getForPrintMember(String loginId) {
		Member member = Container.memberDao.getMemberByLoginId(loginId);
		return member;
	}

	public boolean isJoinableByLoginId(String loginId) {
		return Container.memberDao.isJoinableLoginId(loginId);
	}

	public void addMember(Member member) {
		Container.memberDao.add(member);
	}
}
