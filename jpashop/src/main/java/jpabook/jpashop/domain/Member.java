package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    //기간
    @Embedded
    private Period wordPeriod;

    //주소
    @Embedded
    private Address homeAdrdress;


    //양방향 연관 관계
//    @OneToMany(mappedBy = "MEMBER")
//    private List<Order> orders = new ArrayList<>();


    public Period getWordPeriod() {
        return wordPeriod;
    }

    public void setWordPeriod(Period wordPeriod) {
        this.wordPeriod = wordPeriod;
    }

    public Address getHomeAdrdress() {
        return homeAdrdress;
    }

    public void setHomeAdrdress(Address homeAdrdress) {
        this.homeAdrdress = homeAdrdress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
