package com.develop.ForumRest.service;

import com.develop.ForumRest.model.Status;
import com.develop.ForumRest.model.Topic;
import com.develop.ForumRest.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService implements ITopicService{

    @Autowired
    TopicRepository topicRepository;

    @Override
    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public Topic getTopicById(Long topicId) {
        Optional<Topic> topicOptional = topicRepository.findById(topicId);
        return topicOptional.orElse(null);
    }

    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @Override
    public Topic updateTopic(Long topicId, Topic topicDetails) {
        Topic existingTopic = getTopicById(topicId);
        if (existingTopic != null) {
            // TODO BUSCAR UNA MEJOR FORMA DE HACERLO
            existingTopic.setContent(topicDetails.getContent());
            return topicRepository.save(existingTopic);
        }
        return null;
    }

    @Override
    public void deleteTopic(Long topicId) {
        topicRepository.deleteById(topicId);
    }

    @Override
    public Topic deactivateTopic(Long topicId) {
        Topic existingTopic = getTopicById(topicId);
        if (existingTopic != null) {
            existingTopic.setStatus(Status.INACTIVE);
            return topicRepository.save(existingTopic);
        }
        return null;
    }
}
