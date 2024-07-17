package com.develop.ForumRest.service;

import com.develop.ForumRest.model.Topic;

import java.util.List;

public interface ITopicService {
    Topic createTopic(Topic topic);
    Topic getTopicById(Long topicId);
    List<Topic> getAllTopics();
    Topic updateTopic(Long topicId, Topic topicDetails);
    void deleteTopic(Long topicId);

    Topic deactivateTopic(Long topicId);
}
