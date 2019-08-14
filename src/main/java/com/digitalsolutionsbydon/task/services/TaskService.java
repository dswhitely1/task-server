package com.digitalsolutionsbydon.task.services;

import com.digitalsolutionsbydon.task.model.Task;

import java.util.List;

public interface TaskService
{
    List<Task> findAll();
    Task findTaskById(long id);
    Task save(Task task);
    Task update(Task task, long id);
    void delete(long id);
}
