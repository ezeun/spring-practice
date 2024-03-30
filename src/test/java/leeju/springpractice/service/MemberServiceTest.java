package leeju.springpractice.service;

import leeju.springpractice.domain.Member;
import leeju.springpractice.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception{

        Member member = new Member();
        member.setName("jieun");

        Long saveId = memberService.join(member);

        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복회원예외() throws Exception{

        Member member1 = new Member();
        member1.setName("jieun");

        Member member2 = new Member();
        member2.setName("jieun");

        memberService.join(member1);
        memberService.join(member2);

        fail("예외가 발생해야 함");
    }
}
