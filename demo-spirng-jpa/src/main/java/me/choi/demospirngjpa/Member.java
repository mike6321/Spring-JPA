package me.choi.demospirngjpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Project : demo-spirng-jpa
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 3:58 오후
 */

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String userName;
}
