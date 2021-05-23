package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
            // TODO: 준 영속 상태 2021/05/23 11:36 오후
            Member member = em.find(Member.class, 101L);
            member.setName("aaaa2");

//            em.detach(member);
            em.clear();

            Member member2 = em.find(Member.class, 101L);
            member2.setName("aaaa3");

            tx.commit();
        } catch (Exception e) {
            em.close();
        }
        emf.close();
    }

}
