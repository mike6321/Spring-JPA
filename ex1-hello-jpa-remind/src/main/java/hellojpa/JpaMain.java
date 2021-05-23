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
            // TODO: 플러시 2021/05/23 11:27 오후
            /**
             * commit 시점에 쿼리가 나가는 것이 아닌 flush 하는 시점에 쿼리가 나간다.
             * jpql을 사용하는 시점에 flush가 된다.
             * */
            Member member = new Member(200L, "member200");
            em.persist(member);

            em.flush();
            System.out.println("***************************");

            tx.commit();
        } catch (Exception e) {
            em.close();
        }
        emf.close();
    }

}
