package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Project : jpashop-remind
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:24 오후
 */
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private Long id;

//    @Column(name = "MEMBER_ID")
//    private Long memberId;

    // TODO: memberId 2021/05/31 10:30 오후
    /**
     * id로 참조하는 것이 객체로 참조하는 것이 바람직하다. (객체지향스럽다.)
     * */
    @Column(name = "MEMBER_ID")
    private Member memberId;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getMemberId() {
//        return memberId;
//    }
//
//    public void setMemberId(Long memberId) {
//        this.memberId = memberId;
//    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

}
