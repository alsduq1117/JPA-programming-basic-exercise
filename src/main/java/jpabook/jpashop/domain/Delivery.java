package jpabook.jpashop.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Delivery extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    private String street;
    private String zipcode;
    private String city;

    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery",fetch = LAZY)
    private Order order;

    public Delivery() {
    }
}
