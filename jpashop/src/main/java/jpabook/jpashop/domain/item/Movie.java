package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Project : jpashop
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:45 오후
 */
@Entity
@DiscriminatorValue("M")
@Getter @Setter
public class Movie extends Item{

    private String artist;
    private String actor;

}
