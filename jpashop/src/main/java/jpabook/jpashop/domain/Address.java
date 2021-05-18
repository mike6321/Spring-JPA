package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

/**
 * Project : jpashop
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:27 오후
 */
@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
