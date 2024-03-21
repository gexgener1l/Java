package com.webblog.blog.controllers;

import com.webblog.blog.component.exeption.BadRequestException;
import com.webblog.blog.component.exeption.InternalServerErrorException;
import com.webblog.blog.dtoClasses.TopicDTO;
import com.webblog.blog.serveces.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public List<TopicDTO> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDTO> getTopicById(@PathVariable Long id) {
        try {
            TopicDTO topic = topicService.getTopicById(id);
            return ResponseEntity.ok(new TopicDTO(topic.getId(), topic.getName(), topic.getDescription(), topic.getAuthorsId()));
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (InternalServerErrorException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public TopicDTO saveTopic(@RequestBody TopicDTO topicDTO) {
        TopicDTO topic = new TopicDTO();
        topic.setName(topicDTO.getName());
        topic.setDescription(topicDTO.getDescription());
        topic.setAuthorsId(topicDTO.getAuthorsId());
        topic = topicService.saveTopic(topic);
        return new TopicDTO(topic.getId(), topic.getName(), topic.getDescription(), topic.getAuthorsId());
    }

    @PutMapping("/{id}")
    public TopicDTO updateTopic(@PathVariable Long id, @RequestBody TopicDTO updatedTopicDTO) {
        return topicService.updateTopic(id, updatedTopicDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }

}