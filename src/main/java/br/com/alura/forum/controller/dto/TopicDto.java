package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.model.Topic;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class TopicDto {
	private Long id;
	private String title;
	private String message;
	private LocalDateTime creationDate = LocalDateTime.now();
	
	public TopicDto(Topic topic) {
		this.id = topic.getId();
		this.title = topic.getTitle();
		this.message = topic.getMessage();
		this.creationDate = topic.getCreationDate();
	}

	public static Page<TopicDto> convert(Page<Topic> topics) {
		return topics.map(TopicDto::new);
	}
}
