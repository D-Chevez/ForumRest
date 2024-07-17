package com.develop.ForumRest.model;


import com.develop.ForumRest.dto.CourseCreateDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "course")
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "courseId")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false, unique = true)
    private String courseName;

    private String description;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(
            name = "course_tags",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        status = Status.ACTIVE;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Course(CourseCreateDTO dto, Set<Tag> tags) {
        this.courseName = dto.courseName();
        this.description = dto.description();
        this.status = Status.ACTIVE;
        this.tags = tags;
    }
}
