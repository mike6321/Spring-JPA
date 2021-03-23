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
            // TODO: 양뱡향 연관관계와 연관관계의 주인2 - 주의점, 정리 2021/03/23 10:25 오전
            Team team = new Team();
            team.setName("TeamA");
            entityManager.persist(team);

            Member member = new Member();
            member.setUsername("member1");
//            member.changeTeam(team);
            entityManager.persist(member);

            team.addMember(member);

//            team.getMembers().add(member);


//            entityManager.flush();
//            entityManager.clear();


            Team findTeam = entityManager.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();
            System.out.println();
            System.out.println("*********************************");
            System.out.println("findTeam = " + findTeam);
            System.out.println("*********************************");

            System.out.println("*********************************");
//            for (Member m : members) {
//                System.out.println("member = " + m.getUsername());
//            }
            System.out.println("*********************************");

            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }
}

