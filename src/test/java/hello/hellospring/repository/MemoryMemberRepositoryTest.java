package hello.hellospring.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();             // 테스트하고싶은 클래스 객체 생성
    @AfterEach
    public void afterEach() {
        repository.clearStore();                    // 한개를 실행할때마다 레포지토리를 초기화 시키는 작업
    }
    @Test
    public void save() {
        Member member = new Member();                                       // 객체 생성
        member.setName("Spring");

        repository.save(member);                                            // 객체 저장

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);                                // 검증하는법1
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);   // 검증하는법2
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        Member result = repository.findByName("Spring1").get();

        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        org.assertj.core.api.Assertions.assertThat(result.size()).isEqualTo(2);

    }

}
