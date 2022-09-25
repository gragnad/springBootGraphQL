package com.nasltudio.graphQL.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.nasltudio.graphQL.domain.Member;
import com.nasltudio.graphQL.repository.MemberRepository;
//import graphql.kickstart.tools.GraphQLMutationResolver;
//import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService, GraphQLQueryResolver, GraphQLMutationResolver {
    @Autowired
    MemberRepository memberRepository;

    /*
		query {
		  getAll {
		    memberSn
		  }
		}
	 */
    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMember(int memberSn) {
        return memberRepository.findById(memberSn).get();
    }

    /*
    * createMember(memberSn : 3, memberId: "123", memberEmail: "NONE", memberNumber : "qqq"){
        memberSn
    }
    * */
    @Override
    public Member createMember(int memberSn, String memberId, String memberEmail, String memberNumber) {
        Member targetMember = Member.builder()
                .memberSn(memberSn)
                .memberId(memberId)
                .memberEmail(memberEmail)
                .memberNumber(memberNumber)
                .build();
        return memberRepository.save(targetMember);
    }

    @Override
    public void deleteMember(String memberId) {
        List<Member> members = memberRepository.findAll();
        Member targetMember = new Member();
        for(Member findMember : members) {
            if(findMember.getMemberId().equals(memberId)) {
                targetMember = findMember;
            }
        }
        memberRepository.delete(targetMember);
    }
}
