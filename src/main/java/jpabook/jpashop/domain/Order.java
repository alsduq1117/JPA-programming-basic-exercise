package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name="Orders")
public class Order extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Enumerated
    private OrderStatus status;

    private LocalDateTime localDateTime;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;


    @OneToMany(mappedBy = "order" ,cascade = ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = LAZY, cascade = ALL) // Order를 생성해서 Delivery에 넣을때 자동으로 Delivery 저장
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getOrderDate() {
        return localDateTime;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.localDateTime = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

}