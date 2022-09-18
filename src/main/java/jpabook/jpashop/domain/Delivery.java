package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    private String street;
    private String zipcode;
    private String city;

    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery")
    private Order order;

}
