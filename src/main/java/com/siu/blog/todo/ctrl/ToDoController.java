package com.siu.blog.todo.ctrl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siu.blog.todo.domain.ToDoRequestDTO;
import com.siu.blog.todo.domain.ToDoResponseDTO;
import com.siu.blog.todo.service.ToDoService;

@RestController
@RequestMapping("/api")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping("/savetodo")
    public ResponseEntity<Boolean> saveToDo(@RequestBody ToDoRequestDTO params) {
        Boolean result = toDoService.saveToDo(params);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/gettodo")
    public ResponseEntity<List<ToDoResponseDTO>> getToDo(
        @RequestParam(value = "id") int id,
        @RequestParam(value = "year") int year,
        @RequestParam(value = "month") int month,
        @RequestParam(value = "day") int day) {
                LocalDate date = LocalDate.of(year, month, day);
                ToDoRequestDTO obj = new ToDoRequestDTO();
                obj.setUserid(id);
                obj.setDate(date);
        List<ToDoResponseDTO> result = toDoService.getToDos(obj);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/deletetodo")
    public ResponseEntity<Boolean> deleteToDo(
            @RequestParam(name = "id") Integer id,
            @RequestParam(name = "userid") Integer userid) {
        ToDoRequestDTO params = new ToDoRequestDTO();
        params.setId(id);
        params.setUserid(userid);

        Boolean result = toDoService.deleteToDo(params);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("/updatecompleted")
    public ResponseEntity<Boolean> updateCompleted(@RequestBody ToDoRequestDTO params) {
        Boolean result = toDoService.updateCompleted(params);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/alldeletetodo")
    public ResponseEntity<Boolean> allDeleteToDo(
            @RequestParam(name = "id") Integer id) {
        ToDoRequestDTO params = new ToDoRequestDTO();
        params.setId(id);

        Boolean result = toDoService.allDeleteToDo(params);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("/changestar")
    public ResponseEntity<Boolean> changeStar(@RequestBody ToDoRequestDTO params){
        Boolean result = toDoService.changeStar(params);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/searchtodo")
    public ResponseEntity<List<ToDoResponseDTO>> searchToDo(
        @RequestParam(value="userid") int userid,
        @RequestParam(value="content") String content
        ) {
            ToDoRequestDTO params = new ToDoRequestDTO();
            params.setUserid(userid);
            params.setContent(content);
            List<ToDoResponseDTO> result = toDoService.searchToDo(params);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
}
