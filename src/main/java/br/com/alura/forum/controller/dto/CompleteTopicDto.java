package br.com.alura.forum.controller.dto;

import br.com.alura.forum.model.Answer;
import br.com.alura.forum.model.StatusTopic;
import br.com.alura.forum.model.Topic;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CompleteTopicDto {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate = LocalDateTime.now();
    private String authorName;
    private StatusTopic status;
    private List<AnswerDto> answers;

    public CompleteTopicDto(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.creationDate = topic.getCreationDate();
        this.authorName = topic.getAuthor().getName();
        this.status = topic.getStatus();
        this.answers = new ArrayList<>();
        this.answers.addAll(topic.getAnswers().stream().map(AnswerDto::new).collect(Collectors.toList()));
    }
}
