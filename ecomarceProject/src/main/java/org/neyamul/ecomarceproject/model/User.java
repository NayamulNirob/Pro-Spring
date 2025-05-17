package org.neyamul.ecomarceproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email")
        })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;

    @NotBlank
    @Size(min = 3, max = 50,message = "User name must be between 5 to 50 characters")
    private String userName;

    @NotBlank
    @Email(message = "Email should be valid and cannot be blank")
    @Column(nullable = false)
    private String email;


    @NotBlank
    @Size(min = 5, max = 120,message = "Password must be between 5 to 20 characters")
//  @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{5,20}$", message = "Password must contain at least one uppercase letter, one lowercase letter, and one digit")
    @Pattern(regexp = "^(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{5,20}$",
            message = "Password must be 5-120 characters long and include at least one special character (!@#$%^&*).")
    @Column(nullable = false)
    private String password;


    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "user_roles"
    ,joinColumns = @JoinColumn(name = "userId",referencedColumnName = "userId")
            ,inverseJoinColumns = @JoinColumn(name = "roleId",referencedColumnName = "roleId"))
    @JsonManagedReference
    private Set<Role>roles=new HashSet<>();


    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE,CascadeType.PERSIST},
               orphanRemoval = true)
    private Set<Product> product;

    @ToString.Exclude
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "user_address",
            joinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(name = "addressId", referencedColumnName = "addressId"))
    @JsonManagedReference
    private List<Address> addresses;


}
