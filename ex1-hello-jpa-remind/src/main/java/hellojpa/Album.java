package hellojpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Project : ex1-hello-jpa-remind
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:25 오전
 */
@Entity
public class Album extends Item {

    private String artist;

}
