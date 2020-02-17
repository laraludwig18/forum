package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicDto;
import br.com.alura.forum.model.Topic;
import br.com.alura.forum.repository.TopicRepository;

@RestController
public class TopicsController {

	@Autowired
	private TopicRepository topicRepository;

	@RequestMapping("/topics")
	public List<TopicDto> list(String courseName) {
		List<Topic> topics;

		topics = courseName == null 
				? topicRepository.findAll()
				: topicRepository.findByCourse_Name(courseName);


		return TopicDto.convert(topics);
	}
}
