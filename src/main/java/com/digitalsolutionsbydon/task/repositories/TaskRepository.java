package com.digitalsolutionsbydon.task.repositories;

import com.digitalsolutionsbydon.task.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long>
{
}
