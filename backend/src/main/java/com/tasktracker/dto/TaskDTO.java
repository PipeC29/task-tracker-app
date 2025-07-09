package com.tasktracker.dto;

import com.tasktracker.entity.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskDTO {
    
    private Long id;
    
    @NotBlank(message = "Title cannot be blank")
    @Size(max = 100, message = "Title must be less than 100 characters")
    private String title;
    
    @Size(max = 500, message = "Description must be less than 500 characters")
    private String description;
    
    @NotNull(message = "Status cannot be null")
    private TaskStatus status;
    
    public TaskDTO() {
    }
    
    public TaskDTO(String title, String description, TaskStatus status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }
    
    public TaskDTO(Long id, String title, String description, TaskStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public TaskStatus getStatus() {
        return status;
    }
    
    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}