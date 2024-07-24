package com.nbc.ecommerceApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
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
    @OneToMany(mappedBy = "user")
    private List<Authority> authorities;
}
