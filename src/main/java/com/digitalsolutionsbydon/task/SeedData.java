package com.digitalsolutionsbydon.task;

import com.digitalsolutionsbydon.task.model.Task;
import com.digitalsolutionsbydon.task.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    TaskService taskService;

    @Override
    public void run(String... args) throws Exception
    {
        Task t1 = new Task("A random Task", false, LocalDateTime.now());
        Task t2 = new Task("The Second Task", false, LocalDateTime.now());
        Task t3 = new Task("The Final Task", false, LocalDateTime.now());

        taskService.save(t1);
        taskService.save(t2);
        taskService.save(t3);
    }
}
