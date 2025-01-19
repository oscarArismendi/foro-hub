package com.forohub.foro_hub.topics.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.forohub.foro_hub.courses.domain.entity.Course;
import com.forohub.foro_hub.courses.infrastructure.repository.CourseRepository;
import com.forohub.foro_hub.topics.domain.dto.TopicFullResponse;
import com.forohub.foro_hub.topics.domain.dto.TopicRequest;
import com.forohub.foro_hub.topics.domain.dto.TopicResponse;
import com.forohub.foro_hub.topics.domain.dto.UpdateTopicRequest;
import com.forohub.foro_hub.topics.domain.entity.Topic;
import com.forohub.foro_hub.topics.domain.service.TopicService;
import com.forohub.foro_hub.topics.infrastructure.repository.TopicRepository;
import com.forohub.foro_hub.users.domain.entity.User;
import com.forohub.foro_hub.users.infrastructure.repository.UserRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    @Autowired
    private final TopicRepository topicRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final CourseRepository courseRepository;

    @Override
    public TopicResponse createTopic(TopicRequest request) {

        if (topicRepository.existsByTitleAndMessage(request.title(), request.message())) {
            throw new IllegalArgumentException("A topic with the same title and message already exists.");
        }

        User author = userRepository.findById(request.authorId())
                .orElseThrow(() -> new IllegalArgumentException("Author not found"));

        Course course = courseRepository.findById(request.courseId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        Topic topic = new Topic();
        topic.setTitle(request.title());
        topic.setMessage(request.message());
        topic.setAuthor(author);
        topic.setCourse(course);

        Topic savedTopic = topicRepository.save(topic);

        return new TopicResponse(
            savedTopic.getId(),
            savedTopic.getTitle(),
            savedTopic.getMessage(),
            savedTopic.getStatus()
        );
    }

    @Override
    public Page<TopicResponse> listAll(Pageable pageable) {
        return topicRepository.findAll(pageable)
                              .map(topic -> new TopicResponse(
                                  topic.getId(),
                                  topic.getTitle(),
                                  topic.getMessage(),
                                  topic.getStatus()
                              ));
    }

    @Override
    @Transactional
    public ResponseEntity<TopicFullResponse> update(@PathVariable Long id,@RequestBody @Valid UpdateTopicRequest data) {
         // Retrieve the existing topic by ID
        Topic topic = topicRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Topic with ID " + id + " not found"));

        // Check for duplicate title and message
        boolean existsDuplicate = topicRepository.existsByTitleAndMessageAndIdNot(data.title(), data.message(), id);
        if (existsDuplicate) {
            throw new IllegalArgumentException("A topic with the same title and message already exists.");
        }
        // Update the fields of the topic
        topic.setTitle(data.title());
        topic.setMessage(data.message());
        topic.setStatus(data.status());

        // Optional: If author or course is updated, retrieve and set them
        if (data.authorId() != null) {
        User author = userRepository.findById(data.authorId())
                .orElseThrow(() -> new IllegalArgumentException("User with ID " + data.authorId() + " not found"));
        topic.setAuthor(author);
        }

        if (data.courseId() != null) {
        Course course = courseRepository.findById(data.courseId())
                .orElseThrow(() -> new IllegalArgumentException("Course with ID " + data.courseId() + " not found"));
        topic.setCourse(course);
        }

        // Save the updated topic
        topic = topicRepository.save(topic);

        // Map the updated topic to a TopicFullResponse
        TopicFullResponse response = new TopicFullResponse(
            topic.getTitle(),
            topic.getMessage(),
            topic.getStatus(),
            topic.getAuthor().getId(),
            topic.getCourse().getId()
        );

        // Return the response entity
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<TopicResponse> findTopic(Long id) {
         // Retrieve the existing topic by ID
         Topic topic = topicRepository.findById(id)
         .orElseThrow(() -> new IllegalArgumentException("Topic with ID " + id + " not found"));

         TopicResponse response = new TopicResponse(
            topic.getId(),
            topic.getTitle(),
            topic.getMessage(),
            topic.getStatus()
        );

        return ResponseEntity.ok(response);
    }

}

