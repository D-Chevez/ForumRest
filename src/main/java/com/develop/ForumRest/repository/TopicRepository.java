package com.develop.ForumRest.repository;

import com.develop.ForumRest.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
