package com.develop.ForumRest.repository;

import com.develop.ForumRest.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
