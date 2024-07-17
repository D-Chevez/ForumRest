package com.develop.ForumRest.repository;

import com.develop.ForumRest.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
