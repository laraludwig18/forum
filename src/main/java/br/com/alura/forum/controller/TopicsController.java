package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;

import br.com.alura.forum.controller.dto.CompleteTopicDto;
import br.com.alura.forum.controller.form.TopicForm;
import br.com.alura.forum.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.alura.forum.controller.dto.TopicDto;
import br.com.alura.forum.model.Topic;
import br.com.alura.forum.repository.TopicRepository;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/topics")
public class TopicsController {

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private CourseRepository courseRepository;

	@GetMapping
	public List<TopicDto> list(String courseName) {
		List<Topic> topics;

		topics = courseName == null 
				? topicRepository.findAll()
				: topicRepository.findByCourse_Name(courseName);


		return TopicDto.convert(topics);
	}

	@PostMapping
	public ResponseEntity<TopicDto> create(@RequestBody @Valid TopicForm form, UriComponentsBuilder uriBuilder) {
		Topic topic = form.convert(courseRepository);
		topicRepository.save(topic);

		URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicDto(topic));
	}

	@GetMapping("/{id}")
	public CompleteTopicDto find(@PathVariable Long id) {
		Topic topic = topicRepository.getOne(id);

		return new CompleteTopicDto(topic);
	}
}
