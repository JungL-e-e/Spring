package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//  @Service         컴포넌트 스캔 사용법
public class MemberService {

    private final MemberRepository memberRepository;

//    @Autowired         컴포넌트 스캔 사용법
    public MemberService(MemberRepository memberRepository) {   // 이걸로 인해서 테스트가 편해짐, 추가공부 필요
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 중복 회원 불가능
        // Optional<Member> result = memberRepository.findByName(member.getName()); 이 방법도 좋지만
        validateDuplicateMember(member);    // ctrl + alt + m = extract method
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


}

