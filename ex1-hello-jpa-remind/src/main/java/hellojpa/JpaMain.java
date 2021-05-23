package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Project : ex1-hello-jpa-remind
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 4:03 오후
 */
public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // TODO: 삽입 2021/05/23 5:13 오후
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");

//            em.persist(member);

            // TODO: 조회1 2021/05/23 5:13 오후
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getName());

            // TODO: 조회2 2021/05/23 5:26 오후
            List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList();
            for (Member member : result) {
                System.out.println("member.id = " + member.getId());
                System.out.println("member.name = " + member.getName());
            }

            // TODO: 수정 2021/05/23 5:14 오후
//            findMember.setName("HelloJPA");

            tx.commit();
        } catch (Exception e) {
            em.close();
        }
        emf.close();
    }

}
