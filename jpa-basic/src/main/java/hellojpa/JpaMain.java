package hellojpa;

import javax.persistence.*;
import java.util.List;

/**
 * Project : jpa-basic
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 6:41 오후
 */
public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        try {
            // TODO: 비영속 상태 2021/02/22 9:18 오후
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

            // TODO: 영속 2021/02/22 9:18 오후
            /**
             * 영속상태가 된다해서 DB에 쿼리가 날아가지 않는다.
             * commit 상태에서 쿼리가 날라간다.
             * */
//            System.out.println("*********Before*********");
//            entityManager.persist(member);
//            System.out.println("*********After*********");
//
//            Member findMember1 = entityManager.find(Member.class, 101L);
//            Member findMember2 = entityManager.find(Member.class, 101L);
//
//            System.out.println(findMember1 == findMember2);

//            System.out.println("findMember id = " + findMember1.getId());
//            System.out.println("findMember name = " + findMember1.getName());
//            System.out.println("findMember id = " + findMember2.getId());
//            System.out.println("findMember name = " + findMember2.getName());
//


            // TODO: 테이블 Insert 2021/02/21 7:32 오후
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("junwoo");
//            entityManager.persist(member);

            // TODO: 테이블 데이터 수정 2021/02/21 7:32 오후
            /**
             * entityManager.persist(member) 필요없이
             * 값만 set해도 데이터가 수정된다.
             * */
//            member.setId(2L);
//            member.setName("sunga");
//            Member findMember = entityManager.find(Member.class, 1L);
//            System.out.println(findMember.getId());
//            System.out.println(findMember.getName());
//
//            findMember.setName("junwoo JPA");

            // TODO: JPQL 맛보기 2021/02/21 7:33 오후
//            List<Member> resultList = entityManager.createQuery("select m from Member as m", Member.class)
//                    .setMaxResults(5)
//                    .setMaxResults(8)
//                    .getResultList();
//
//            for (Member member : resultList) {
//                System.out.println(member.getName());
//            }


            // TODO: 커밋을 하는 시점에 쿼리가 나간다. 2021/03/05 12:18 오후
            /**
             * 왜 굳이 이렇게 할까?
             * 최적화 할 수 있는 여지를 남기기 위해!
             */
//            Member member1 = new Member(200L, "A");
//            Member member2 = new Member(201L, "A");
//
//            entityManager.persist(member1);
//            entityManager.persist(member2);
//
//            System.out.println("*********");

            // TODO: diryChecking 2021/03/05 12:29 오후
            /**
             * JPA는 값을 Commit하는 시점에 반영된다.
             * persit를 안쓰는 것이 맞다.
             * */
            // TODO: persist를 안쓰는 이유에 대해서 조금 더 구체적으로 알아보기

            //  2021/03/05 12:40 오후
//            Member member = entityManager.find(Member.class, 201L);
//            member.setName("Hello junwoo");

            // TODO: flush 2021/03/10 1:09 오전
//            Member member = new Member(200l, "Member200");
//            entityManager.persist(member);
//
//            entityManager.flush();
//            System.out.println("*********");

            // TODO: 준영속 상태 2021/03/10 1:10 오전
//            Member member = entityManager.find(Member.class, 201L); // 현재는 영속상태
//            member.setName("jun young sok");
//
//            entityManager.detach(member);


//            Member member = new Member();
////            member.setId("ID_A");
//            member.setUsername("Junwoo");
//
//            entityManager.persist(member);
//
//            transaction.commit();
            // TODO: 이전과는 달리 commit 시점이 아닌 persist 시점에 쿼리를 내보낸다 2021/03/14 5:02 오후
            /**
             * 모아서 쿼리를 처리하면 기존의 시퀀스 값을 알 수 없기 때문이다.
             * call next value for MEMBER_SEQ
             * */
            Member member1 = new Member();
            member1.setUsername("A");

            Member member2 = new Member();
            member2.setUsername("B");

            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println("*********");

            entityManager.persist(member1);
            entityManager.persist(member2);
            entityManager.persist(member3);

            System.out.println(member1.getId());
            System.out.println(member2.getId());
            System.out.println(member3.getId());
            System.out.println("*********");

            transaction.commit();

        } catch (Exception exception) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }
}
/**
 * create table Member(
 *     id bigint not null,
 *     name varchar(255),
 *     primary key(id)
 * )
 * */

