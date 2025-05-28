package org.neyamul.ecomarceproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min = 3, message = "Recipient name should atLeast  3 characters")
    @Column(name = "recipient_name")
    private String recipientName;

    @NotBlank
    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @NotBlank
    @Size(min = 3, message = "City name should atLeast  3 characters")
    @Column(name = "city") // city or town
    private String city;

    @NotBlank
    @Size(min = 3, message = "State name should atLeast  3 characters")
    @Column(name = "state") // state or province
    private String state;

    @NotBlank
    @Size(min = 3 ,message = "Postal code should atLeast  3 characters")
    @Column(name = "postal_code")
    private String postalCode;

    @NotBlank
    @Size(min = 3, message = "Country name should atLeast  3 characters")
    @Column(name = "country")
    private String country;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
