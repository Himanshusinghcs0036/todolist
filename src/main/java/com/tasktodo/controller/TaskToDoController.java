package com.tasktodo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tasktodo.model.Task;
import com.tasktodo.model.TaskDto;
import com.tasktodo.model.TaskResponseDto;
import com.tasktodo.service.TaskToDoService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskToDoController {

	@Autowired
	private TaskToDoService taskToDoService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public TaskResponseDto addTask(@RequestBody TaskDto taskDto) {
		return taskToDoService.addTask(taskDto.getDescription());
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Map<String, Task> getTasks() {
		return taskToDoService.getTasks();
	}

	@PutMapping(value = "/complete/{taskId}")
	@ResponseStatus(code = HttpStatus.OK)
	public String completeTask(@PathVariable String taskId) {
		return taskToDoService.completeTask(taskId);
	}

	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	public String updateTask(@RequestBody Task updatedTask) {
		return taskToDoService.updateTask(updatedTask.getId(), updatedTask.getDesc());
	}

	@DeleteMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteCompletedTask() {
		taskToDoService.deleteCompletedTask();
	}
}
