package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Project : jpabook
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:13 오후
 */
@Entity
public class Order {
    @Id @GeneratedValue
    private Long id;

    private Long memberId;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING )
    private OrderState state;

}
