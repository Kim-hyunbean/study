package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //키값생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //아이디셋
        store.put(member.getId(), member); //스토어에저장
        return member; //결과반환

    }

    @Override
    public Optional<Member> findByid(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //람다 루프를 돌리는것
                .filter(member -> member.getName().equals(name)) //meber.name==name
                .findAny(); //끝까지 찾아서 결과가없으면 null
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
