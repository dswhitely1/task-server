package com.digitalsolutionsbydon.task.controllers;

import com.digitalsolutionsbydon.task.model.Task;
import com.digitalsolutionsbydon.task.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TaskController
{
    @Autowired
    TaskService taskService;

    @GetMapping(value = "/tasks", produces = {"application/json"})
    public ResponseEntity<?> allTasks()
    {
        List<Task> list = taskService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/task/{id}", produces = {"application/json"})
    public ResponseEntity<?> getTaskById(@PathVariable long id)
    {
        Task t = taskService.findTaskById(id);
        return new ResponseEntity<>(t,HttpStatus.OK);
    }

    @PostMapping(value = "/task", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addTask(@RequestBody Task task)
    {
        taskService.save(task);
        List<Task> t = taskService.findAll();
        return new ResponseEntity<>(t, HttpStatus.CREATED);
    }

    @PutMapping(value="/task/{id}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> updateTask(@RequestBody Task updatedTask, @PathVariable long id)
    {
        taskService.update(updatedTask, id);
        List<Task> t = taskService.findAll();
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @DeleteMapping(value="/task/{id}", produces = {"application/json"})
    public ResponseEntity<?> deleteTask(@PathVariable long id)
    {
        taskService.delete(id);
        List<Task> t = taskService.findAll();
        return new ResponseEntity<>(t, HttpStatus.OK);
    }
}
