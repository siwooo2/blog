package com.siu.blog.todo.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class ToDoResponseDTO {
    private int id;
    private String content;
    private boolean completed;
    private LocalDate date;
    private LocalTime time;
    private boolean special;
}
