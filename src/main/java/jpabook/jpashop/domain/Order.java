package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Orders")
public class Order extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Enumerated
    private OrderStatus status;

    private LocalDateTime localDateTime;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;


    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
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