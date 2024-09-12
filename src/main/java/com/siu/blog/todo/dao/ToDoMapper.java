package com.siu.blog.todo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.siu.blog.todo.domain.ToDoRequestDTO;
import com.siu.blog.todo.domain.ToDoResponseDTO;

@Mapper
public interface ToDoMapper {

    public void saveToDo(ToDoRequestDTO params);

    public List<ToDoResponseDTO> getToDos(ToDoRequestDTO params);

    public void deleteToDo(ToDoRequestDTO params);

    public void updateCompleted(ToDoRequestDTO params);

    public void allDeleteToDo(ToDoRequestDTO params);

    public void changeStar(ToDoRequestDTO params);
} 
