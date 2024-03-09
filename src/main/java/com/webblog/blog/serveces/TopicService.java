package com.webblog.blog.serveces;

import com.webblog.blog.dtoClasses.TopicDTO;
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

    @Autowired
    private TopicRepository topicRepository;

    public List<TopicDTO> getAllTopics() {
        List<Topic> topics = topicRepository.findAll();
        return topics.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
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

        // Convert AuthorDTOs to Author entities if needed
        // Set<Author> authors = mapAuthorsToEntities(topicDTO.getAuthorsId());
        // topic.setAuthors(authors);

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

        // Update the existing topic's properties
        existingTopic.setName(updatedTopicDTO.getName());
        existingTopic.setDescription(updatedTopicDTO.getDescription());
        existingTopic.setAuthorsId(updatedTopicDTO.getAuthorsId());
        // Save the updated topic
        existingTopic = topicRepository.save(existingTopic);

        return convertToDTO(existingTopic);
    }
}