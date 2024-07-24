package com.nbc.ecommerceApp.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authority implements GrantedAuthority {
    @Id
    @SequenceGenerator(name = "authority_sequence", sequenceName = "authority_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authority_sequence")
    private Long authorityId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="username", referencedColumnName = "username")
    private User user;
    private String authority;
    private boolean active;

}
