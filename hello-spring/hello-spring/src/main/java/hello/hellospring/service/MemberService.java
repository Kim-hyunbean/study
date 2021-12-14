package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    //멤버레포지토리가 필요
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //같은걸 사용하게끔 바꾸는 방법
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        //Optional method를 사용하기 위해 사용
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> { //ifPresent 값이 있으면
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        validateDuplicateMeber(member); //중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMeber(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> { //ifPresent 값이 있으면
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findONe(Long memberId) {
        return memberRepository.findByid(memberId);
    }
}
