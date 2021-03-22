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
            // TODO: 단반향 연관관계 2021/03/22 9:16 오후
            // 저장
            Team team = new Team();
            team.setName("TeamA");
            entityManager.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
//            member.setTeamId(team.getId());
            entityManager.persist(member);

            // 찾기
            Member findMember = entityManager.find(Member.class, member.getId());
            Team findTeam = findMember.getTeam();
            System.out.println("findTeam " + findTeam.getName());

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

