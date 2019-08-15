package com.digitalsolutionsbydon.task.services;

import com.digitalsolutionsbydon.task.model.Task;
import com.digitalsolutionsbydon.task.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value="taskService")
public class TaskServiceImpl implements TaskService
{
    @Autowired
    TaskRepository taskRepo;

    @Override
    public List<Task> findAll()
    {
        List<Task> list = new ArrayList<>();
        taskRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Task findTaskById(long id)
    {
        return taskRepo.findById(id).orElseThrow(()->new EntityNotFoundException(Long.toString(id)));
    }

    @Transactional
    @Override
    public Task save(Task task)
    {
        Task newTask = new Task();
        newTask.setTask(task.getTask());
        newTask.setCompleted(false);
        newTask.setCreatedat(LocalDateTime.now());

        return taskRepo.save(newTask);
    }

    @Transactional
    @Override
    public Task update(Task task, long id)
    {
        Task updatedTask = taskRepo.findById(id).orElseThrow(()->new EntityNotFoundException(Long.toString(id)));

        updatedTask.setCompleted(task.isCompleted());

        return taskRepo.save(updatedTask);
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        if (taskRepo.findById(id).isPresent())
        {
            taskRepo.deleteById(id);
        } else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }
}
