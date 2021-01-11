package com.kmt.jpaspec;

import com.kmt.jpaspec.domain.Class;
import com.kmt.jpaspec.domain.Member;
import com.kmt.jpaspec.repository.ClassRepository;
import com.kmt.jpaspec.repository.MemberRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(properties="spring.main.banner-mode=off")
@Transactional
class JpaSpecApplicationTests {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ClassRepository classRepository;

    @BeforeAll
    public void init() {
        memberRepository.deleteAll();
        classRepository.deleteAll();

        Class classWaterPolo = new Class();
        classWaterPolo.setName("Water Polo");
        classRepository.save(classWaterPolo);

        Class classSwimming = new Class();
        classSwimming.setName("Swimming");
        classRepository.save(classSwimming);

        Class classLifting = new Class();
        classLifting.setName("Lifting");
        classRepository.save(classLifting);

        Class classPilates = new Class();
        classPilates.setName("Pilates");
        classRepository.save(classPilates);

        Class classZumba = new Class();
        classZumba.setName("Zumba");
        classRepository.save(classZumba);

        Set<Class> gregSet = new HashSet<>();
        gregSet.add(classWaterPolo);
        gregSet.add(classLifting);

        Member memberGreg = new Member();
        memberGreg.setActive(true);
        memberGreg.setFirstName("Greg");
        memberGreg.setLastName("Brady");
        memberGreg.setInterests("I love to cycle and swim");
        memberGreg.setZipCode("90210");
        memberGreg.setClasses(gregSet);
        memberRepository.save(memberGreg);

        Set<Class> marshaSet = new HashSet<>();
        marshaSet.add(classSwimming);
        marshaSet.add(classZumba);

        Member memberMarsha = new Member();
        memberMarsha.setActive(true);
        memberMarsha.setFirstName("Marsha");
        memberMarsha.setLastName("Brady");
        memberMarsha.setInterests("I love to do zumba and pilates");
        memberMarsha.setZipCode("90211");
        memberMarsha.setClasses(marshaSet);
        memberRepository.save(memberMarsha);

        Set<Class> aliceSet = new HashSet<>();
        aliceSet.add(classSwimming);

        Member memberAlice = new Member();
        memberAlice.setActive(false);
        memberAlice.setFirstName("Alice");
        memberAlice.setLastName("Nelson");
        memberAlice.setInterests("I used to love that belt machine-y thing");
        memberAlice.setZipCode("90201");
        memberAlice.setClasses(aliceSet);
        memberRepository.save(memberAlice);
    }

//    @Test
//    void contextLoads() { }

    @Test
    public void testMembersActive() {
        List<Member> memberList = memberRepository.findAll();
        assertEquals(3, memberList.size());
    }


}
