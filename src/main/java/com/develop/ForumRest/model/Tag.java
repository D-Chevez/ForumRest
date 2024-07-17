package com.develop.ForumRest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name = "tag")
@Table(name = "tags")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(nullable = false, unique = true)
    private String tagName;

    @ManyToMany(mappedBy = "tags")
    private Set<Course> courses;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @PrePersist
    protected void onCreate() {
        status = Status.ACTIVE;
    }

}
