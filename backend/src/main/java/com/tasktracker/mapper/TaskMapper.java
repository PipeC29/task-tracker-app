package com.tasktracker.mapper;

import com.tasktracker.dto.TaskDTO;
import com.tasktracker.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    
    public TaskDTO toDTO(Task task) {
        return new TaskDTO(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getStatus()
        );
    }
    
    public Task toEntity(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        return task;
    }
}