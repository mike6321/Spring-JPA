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
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            // TODO: 영속 2021/02/22 9:18 오후
            /**
             * 영속상태가 된다해서 DB에 쿼리가 날아가지 않는다.
             * commit 상태에서 쿼리가 날라간다.
             * */
            System.out.println("*********Before*********");
            entityManager.persist(member);
            System.out.println("*********After*********");

            Member findMember = entityManager.find(Member.class, 101L);

            System.out.println("findMember id = " + findMember.getId());
            System.out.println("findMember name = " + findMember.getName());


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
