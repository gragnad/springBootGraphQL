package com.nasltudio.graphQL.service;

import com.nasltudio.graphQL.domain.Member;

import java.util.List;

public interface MemberService {
    public List<Member> getAll();

    public Member getMember(int memberSn);

    public Member createMember(int memberSn, String memberId, String memberEmail, String memberNumber);

    public void deleteMember(String memberId);
}
