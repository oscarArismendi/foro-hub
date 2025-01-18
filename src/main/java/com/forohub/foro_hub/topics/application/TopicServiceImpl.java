package com.forohub.foro_hub.topics.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.forohub.foro_hub.courses.domain.entity.Course;
import com.forohub.foro_hub.courses.infrastructure.repository.CourseRepository;
import com.forohub.foro_hub.topics.domain.dto.TopicRequest;
import com.forohub.foro_hub.topics.domain.dto.TopicResponse;
import com.forohub.foro_hub.topics.domain.entity.Topic;
import com.forohub.foro_hub.topics.domain.service.TopicService;
import com.forohub.foro_hub.topics.infrastructure.repository.TopicRepository;
import com.forohub.foro_hub.users.domain.entity.User;
import com.forohub.foro_hub.users.infrastructure.repository.UserRepository;

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

}

