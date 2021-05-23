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
            // TODO: 비영속 상태 2021/05/23 7:29 오후
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            // TODO: 영속 상태 2021/05/23 7:30 오후
            /**
             * DB에 저장되는 상태는 아니다.
             * */
            System.out.println("=========BEFORE=========");
            em.persist(member);
            System.out.println("=========AFTRE=========");


            tx.commit();
        } catch (Exception e) {
            em.close();
        }
        emf.close();
    }

}
