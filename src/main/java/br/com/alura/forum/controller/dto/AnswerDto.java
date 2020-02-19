package br.com.alura.forum.controller.dto;

import br.com.alura.forum.model.Answer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnswerDto {
    private Long id;
    private String message;
    private LocalDateTime creationDate;
    private String authorName;

    public AnswerDto(Answer answer) {
        this.id = answer.getId();
        this.message = answer.getMessage();
        this.creationDate = answer.getCreationDate();
        this.authorName =  answer.getAuthor().getName();
    }
}
