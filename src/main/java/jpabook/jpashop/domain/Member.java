package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER")
    private Long id;

    private String city;

    private String street;

    private String zipcode;


    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();


}