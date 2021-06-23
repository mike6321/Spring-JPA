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
            //저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("junwoo");
            member.setTeam(team);
            em.persist(member);

//            em.flush();
//            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();
            for (Member member1 : members) {
                System.out.println("member1 = " + member1);
            }

            tx.commit();
        } catch (Exception e) {
            em.close();
        }
        emf.close();
    }

}
