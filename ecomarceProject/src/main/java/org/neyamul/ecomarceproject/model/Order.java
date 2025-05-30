package org.neyamul.ecomarceproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Email
    @Column(nullable = false)
    private String email;

    private LocalDate orderDate;
    private Double totalAmount;
    private String orderStatus;
    private Integer quantity;
    private Double discount;
    private Double orderedProductPrice;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<OrderItem> orderItems;

    @OneToOne
    @JoinColumn(name="payment_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name="address_id")
    private Address address;



}
