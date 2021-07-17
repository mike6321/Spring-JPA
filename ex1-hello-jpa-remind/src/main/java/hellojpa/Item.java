package hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Project : ex1-hello-jpa-remind
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:24 오전
 */
@Entity
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;

}
