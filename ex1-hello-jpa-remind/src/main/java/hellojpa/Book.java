package hellojpa;

import javax.persistence.Entity;

/**
 * Project : ex1-hello-jpa-remind
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:26 오전
 */
@Entity
public class Book extends Item {

    private String author;
    private String isbn;


}
