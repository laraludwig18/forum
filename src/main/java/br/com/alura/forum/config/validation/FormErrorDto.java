package br.com.alura.forum.config.validation;

import lombok.Data;

@Data
public class FormErrorDto {
    private String field;
    private String errorMessage;

    public FormErrorDto(String field, String errorMessage) {
        this.field = field;
        this.errorMessage = errorMessage;
    }
}
