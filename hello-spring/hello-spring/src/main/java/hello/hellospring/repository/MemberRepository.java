package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //저장
    Optional<Member> findByid(Long id); //아이디로 회원찾기
    Optional<Member> findByName(String name); //Opitional 찾는게없을때 null을 감싸서 반환
    List<Member> findAll(); //저장된 모든리스트 반환
}
