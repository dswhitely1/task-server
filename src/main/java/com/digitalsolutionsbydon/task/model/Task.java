package com.digitalsolutionsbydon.task.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long taskid;

    private String task;
    private boolean completed;
    private LocalDateTime createdat;

    public Task()
    {
    }

    public Task(String task, boolean completed, LocalDateTime createdat)
    {
        this.task = task;
        this.completed = completed;
        this.createdat = createdat;
    }

    public long getTaskid()
    {
        return taskid;
    }

    public String getTask()
    {
        return task;
    }

    public void setTask(String task)
    {
        this.task = task;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public LocalDateTime getCreatedat()
    {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat)
    {
        this.createdat = createdat;
    }
}
