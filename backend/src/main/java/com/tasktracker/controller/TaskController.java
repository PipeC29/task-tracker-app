package com.tasktracker.controller;

import com.tasktracker.dto.TaskDTO;
import com.tasktracker.entity.Task;
import com.tasktracker.entity.TaskStatus;
import com.tasktracker.mapper.TaskMapper;
import com.tasktracker.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
    @Autowired
    private TaskMapper taskMapper;
    
    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks(@RequestParam(required = false) TaskStatus status) {
        List<Task> tasks;
        if (status != null) {
            tasks = taskService.getTasksByStatus(status);
        } else {
            tasks = taskService.getAllTasks();
        }
        List<TaskDTO> taskDTOs = tasks.stream()
                .map(taskMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(taskDTOs);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(t -> ResponseEntity.ok(taskMapper.toDTO(t)))
                  .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<TaskDTO>> searchTasks(@RequestParam String title) {
        List<Task> tasks = taskService.searchTasksByTitle(title);
        List<TaskDTO> taskDTOs = tasks.stream()
                .map(taskMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(taskDTOs);
    }
    
    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody TaskDTO taskDTO) {
        Task task = taskMapper.toEntity(taskDTO);
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskMapper.toDTO(createdTask));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @Valid @RequestBody TaskDTO taskDTO) {
        try {
            Task taskDetails = taskMapper.toEntity(taskDTO);
            Task updatedTask = taskService.updateTask(id, taskDetails);
            return ResponseEntity.ok(taskMapper.toDTO(updatedTask));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        try {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}