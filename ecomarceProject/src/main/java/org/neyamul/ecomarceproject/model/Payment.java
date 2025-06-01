package org.neyamul.ecomarceproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private String pgPaymentId;
    private String pgStatus; //pg for payment gateway e.g., "succeeded", "pending", etc.
    private String pgResponseMessage;// JSON response from Stripe
    private String pgName; // Name of the payment gateway e.g., "Stripe", "PayPal", etc.

    @OneToOne(mappedBy = "payment", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Order order;


    @NotBlank
    @Size(min = 3, message = "Payment method cannot be blank & must contain at least 3 characters")
    private String paymentMethod; // e.g., "Credit Card", "PayPal", etc.


    public Payment(String paymentMethod, String pgPaymentId, String pgName, String pgStatus, String pgResponseMessage) {
        this.paymentMethod = paymentMethod;
        this.pgPaymentId = pgPaymentId;
        this.pgName = pgName;
        this.pgStatus = pgStatus;
        this.pgResponseMessage = pgResponseMessage;
    }
}
