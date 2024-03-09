package com.webblog.blog.serveces;

import com.webblog.blog.dtoclasses.TopicDTO;
import com.webblog.blog.model.Topic;
import com.webblog.blog.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<TopicDTO> getAllTopics() {
        List<Topic> topics = topicRepository.findAll();
        return topics.stream()
                .map(this::convertToDTO)
                .toList();  // Use Stream.toList() instead of Collectors.toList()
    }

    public TopicDTO getTopicById(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic not found with id: " + id));
        return convertToDTO(topic);
    }

    public TopicDTO saveTopic(TopicDTO topicDTO) {
        Topic topic = new Topic();
        topic.setName(topicDTO.getName());
        topic.setDescription(topicDTO.getDescription());
        topic.setAuthorsId(topicDTO.getAuthorsId());
        topic = topicRepository.save(topic);
        return convertToDTO(topic);
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }

    private TopicDTO convertToDTO(Topic topic) {
        return new TopicDTO(topic.getId(), topic.getName(), topic.getDescription(), topic.getAuthorsId());
    }
    public TopicDTO updateTopic(Long id, TopicDTO updatedTopicDTO) {
        Topic existingTopic = topicRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic not found with id: " + id));

        existingTopic.setName(updatedTopicDTO.getName());
        existingTopic.setDescription(updatedTopicDTO.getDescription());
        existingTopic.setAuthorsId(updatedTopicDTO.getAuthorsId());
        existingTopic = topicRepository.save(existingTopic);

        return convertToDTO(existingTopic);
    }
}