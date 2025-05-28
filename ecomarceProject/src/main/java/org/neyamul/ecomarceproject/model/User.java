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
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "userName")
        })
public class User {

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

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
    @Size(min = 5, max = 120,message = "Password must be between 5 to 120 characters")
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{5,120}$",
//           message = "Password must be 5-120 characters long and include at least one uppercase letter, one lowercase letter, one digit, and one special character (!@#$%^&*).")
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
    @OneToMany(mappedBy = "user",cascade = {CascadeType.MERGE,CascadeType.PERSIST},orphanRemoval = true)
//    @JoinTable(name = "user_address",
//            joinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"),
//            inverseJoinColumns = @JoinColumn(name = "addressId", referencedColumnName = "addressId"))
    private List<Address> addresses;


    @ToString.Exclude
    @OneToOne(mappedBy = "user", cascade = { CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Cart cart;


}
