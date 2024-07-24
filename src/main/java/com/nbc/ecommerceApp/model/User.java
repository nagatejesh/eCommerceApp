package com.nbc.ecommerceApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_users")
public class User {

    @Id
    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Authority> authorities;
}
