package com.develop.ForumRest.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "role")
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "roleId")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(nullable = false, unique = true)
    private String roleName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    protected void onCreate() {
        status = Status.ACTIVE;
    }

}
