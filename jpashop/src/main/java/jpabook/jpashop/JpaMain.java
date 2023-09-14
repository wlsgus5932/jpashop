package jpabook.jpashop;

import jpabook.jpashop.domain.*;
import org.hibernate.type.LocalDateTimeType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("jinhyuns");
            member.setAddress(new Address("city", "spring", "100000"));
            em.persist(member);

            Order order = new Order();
            order.setMember(member);
            em.persist(order);

            Movie movie = new Movie();
            movie.setName("movie name");
            movie.setActor("actor");
            movie.setDirector("director");
            em.persist(movie);

            Delivery delivery = new Delivery();
            delivery.setAddress(new Address("city", "street", "100000"));
            em.persist(delivery);

            List<Member> result = em.createQuery("select m from Member m where m.username = '박진현'", Member.class)
                    .getResultList();

            List<Delivery> result2 = em.createQuery("select s from Delivery s", Delivery.class)
                    .getResultList();

            System.out.println("size:" + result.size());

            for (Member member1 : result) {
                System.out.println(member1.getUsername());
            }
            for (Delivery delivery1 : result2) {
                System.out.println(delivery1.getAddress().getCity());
            }

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
