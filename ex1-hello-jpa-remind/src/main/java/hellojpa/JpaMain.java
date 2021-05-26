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
            Member member = new Member();
//            member.setId("ID_A");
            member.setUsername("junwoo");
            System.out.println("***********커밋 이전***********");
            em.persist(member);
            System.out.println("***********커밋 이전***********");
            tx.commit();
        } catch (Exception e) {
            em.close();
        }
        emf.close();
    }

}
