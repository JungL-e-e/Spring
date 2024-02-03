package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
//  import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class springConfig {
    private final MemberRepository memberRepository;
    public springConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


//    private EntityManager em;                         JPA
//
//    @Autowired
//    public springConfig(EntityManager em) {
//        this.em = em;
//    }

//    private DataSource dataSource;

//    @Autowired
//   public springConfig(DataSource dataSource) {
//       this.dataSource = dataSource;
//   }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);              // JDBC
////        return new JdbcTemplateMemberRepository(dataSource);      // JDBC Template
////        return new JpaMemberRepository(em);                       // JPA
//    }
}
