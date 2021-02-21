package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Project : jpa-basic
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 7:04 오후
 */
@Entity
public class Member {
    @Id
    private long id; //PK
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
