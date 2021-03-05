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
//            entityManager.detach(member);
//            System.out.println("*********After*********");

//            Member findMember1 = entityManager.find(Member.class, 101L);
//            Member findMember2 = entityManager.find(Member.class, 101L);
//
//            System.out.println(findMember1 == findMember2);
//
//            System.out.println("findMember id = " + findMember1.getId());
//            System.out.println("findMember name = " + findMember1.getName());
//
//            System.out.println("findMember id = " + findMember2.getId());
//            System.out.println("findMember name = " + findMember2.getName());


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
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "A");
//
//            entityManager.persist(member1);
//            entityManager.persist(member2);

//            System.out.println("*********");

            
            // TODO: diryChecking 2021/03/05 12:29 오후
            /**
             * JPA는 값을 Commit하는 시점에 반영된다.
             * persit를 안쓰는 것이 맞다.
             * */
            // TODO: persist를 안쓰는 이유에 대해서 조금 더 구체적으로 알아보기 2021/03/05 12:39 오후
            Member member = entityManager.find(Member.class, 150L);
            member.setName("Hello Kakao");

//            if (member.getName().equals("Hello Kakao")) {
//                entityManager.persist(member);
//            }

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
