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
            // TODO: 양뱡향 연관관계와 연관관계의 주인1 2021/03/23 10:25 오전
            // 저장
            System.out.println("*******************************");
            Team team = new Team();
            team.setName("TeamA");
            entityManager.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            entityManager.persist(member);
            System.out.println("*******************************");
            
            // TODO: flush, clear 까리한 부분 2021/03/23 11:05 오전
            System.out.println("*******************************");
            entityManager.flush(); // 바로 쿼리 나간다.
//            entityManager.clear(); //영속성 컨텍스트 초기화 (1차 캐시 삭제)
            System.out.println("*******************************");
//            entityManager.detach(member);

            System.out.println();
            // 찾기
            Member findMember = entityManager.find(Member.class, member.getId()); // 이렇게 하면 다시 영속성 컨텍스트 생성
            List<Member> members = findMember.getTeam().getMembers();
            for (Member m : members) {
                System.out.println("members = " + m.getUsername());
            }

            transaction.commit();

        } catch (Exception exception) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }
}

