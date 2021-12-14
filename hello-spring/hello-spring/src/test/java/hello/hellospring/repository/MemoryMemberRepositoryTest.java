package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //끝날때마다 호출되는 메서드
    public void afterEach() {
        repository.clearStore();
    }

    //성공시 초록색 실패시 빨간색
    @Test //메서드를 실행시켜서 테스트해보는것
    public  void save() {
        Member member = new Member();
        member.setName("테스팅");

        repository.save(member);

        Member result = repository.findByid(member.getId()).get(); //repository의 값을 가져와서
        //Assertions.assertEquals(member, result); // result와 member가 같은지 확인 주피터
        assertThat(member).isEqualTo(result); //Assertions static import api

    }

    @Test
    public void findByname() {
        Member member1 = new Member();
        member1.setName("testing1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("testing2");
        repository.save(member2);

        Member result = repository.findByName("testing1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("testing1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("testing2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
