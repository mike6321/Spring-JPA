package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * Project : jpashop
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:19 오전
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired private MemberService memberService;
    @Autowired private MemberRepository memberRepository;
    @Autowired private EntityManager em;

    @Test
    public void 회원가입() {
        //given
        Member member = new Member();
        member.setName("choi");

        //when
        Long savedId = memberService.join(member);

        //then
        em.flush();
        assertThat(member).isEqualTo(memberRepository.findOnd(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("choi1");
        Member member2 = new Member();
        member2.setName("choi1");

        //when
        memberService.join(member1);
        memberService.join(member2);

        //then
        fail("예외가 발생해야한다.");
    }
}