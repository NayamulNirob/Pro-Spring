package org.neyamul.ecomarceproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    @Size(min = 5, max = 50,message = "User name must be between 5 to 50 characters")
    private String userName;

    @NotBlank
    @Email(message = "Email should be valid and cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    @Column(unique = true, nullable = false)
    private String email;


    @NotBlank
    @Size(min = 5, max = 20,message = "Password must be between 5 to 20 characters")
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{5,20}$", message = "Password must contain at least one uppercase letter, one lowercase letter, and one digit")
    @Pattern(regexp = "^(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{5,20}$", message = "Password must contain Uppercase,Lowercase,number and at least one special character")
    @Column(unique = true)
    private String password;


    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "user_role"
    ,joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "userId")
            ,inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "roleId"))
    private Set<Role>roles=new HashSet<>();


}
