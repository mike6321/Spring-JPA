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
//            Member member = new Member();
//            member.setId(102L);
//            member.setName("HelloJPA");
//
//            em.persist(member);

            // TODO: 1차 캐시 2021/05/23 9:27 오후
            /**
             * - persist를 하고 동일한 값을 찾으면 1차 캐시에서 바로 찾기 때문에 select 쿼리가 생성되지 않는다.
             * - persist를 하고 다른 값을 찾으면 DB에서 값을 찾아야하기 때문에 select 쿼리가 생성된다.
             * - persist를 하지 않고 값을 찾으면 첫 번째 탐색 시에는 DB에서 값을 찾지만 두 번째 탐색 시 부턴 1차캐시에서 값을 탐색하므로
             *   select 쿼리가 발생하지 않는다.
             *   (새로운 EntityManager이기 때문이다.)
             * - find는 커밋 시점이 아니라 호출 시점에 select 쿼리가 나간다.
             * */
            System.out.println("***********BEFORE***********");
            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);
            System.out.println("***********AFTER***********");

            System.out.println("findMember.getId() = " + findMember1.getId());
            System.out.println("findMember.getName() = " + findMember1.getName());

            System.out.println("findMember1 == findMember2 :: " + (findMember1 == findMember2));
            
            
            // TODO: 변경 감지 2021/05/23 9:55 오후 
            /**
             * set만 했을 뿐인데 데이터가 변경되었다.
             * (persist는 할 필요가 없다. )
             * - 1차
             * */
            findMember2.setName("jwdeveloper");

            tx.commit();
        } catch (Exception e) {
            em.close();
        }
        emf.close();
    }

}
