package com.siu.blog.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siu.blog.todo.dao.ToDoMapper;
import com.siu.blog.todo.domain.ToDoRequestDTO;
import com.siu.blog.todo.domain.ToDoResponseDTO;

@Service
public class ToDoService {
    
    @Autowired
    private ToDoMapper toDoMapper;

    public Boolean saveToDo(ToDoRequestDTO params){
        toDoMapper.saveToDo(params);
        return true;
    }

    public List<ToDoResponseDTO> getToDos(ToDoRequestDTO params){
        return toDoMapper.getToDos(params);
    }

    public Boolean deleteToDo(ToDoRequestDTO params){
        toDoMapper.deleteToDo(params);
        return true;
    }

    public Boolean updateCompleted(ToDoRequestDTO params){
        toDoMapper.updateCompleted(params);
        return true;
    }

    public Boolean allDeleteToDo(ToDoRequestDTO params){
        toDoMapper.allDeleteToDo(params);
        return true;
    }

    public Boolean changeStar(ToDoRequestDTO params){
        toDoMapper.changeStar(params);
        return true;
    }
}
