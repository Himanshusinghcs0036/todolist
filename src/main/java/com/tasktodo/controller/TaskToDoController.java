package com.tasktodo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tasktodo.model.Task;
import com.tasktodo.service.TaskToDoService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskToDoController {

	@Autowired
	private TaskToDoService taskToDoService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public String addTask(@RequestBody String description) {
		return taskToDoService.addTask(description);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK)
	public Map<String, Task> getTasks() {
		return taskToDoService.getTasks();
	}

	@RequestMapping(value = "/complete/{taskId}", method = RequestMethod.PUT)
	@ResponseStatus(code = HttpStatus.OK)
	public String completeTask(@PathVariable String taskId) {
		return taskToDoService.completeTask(taskId);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(code = HttpStatus.OK)
	public String updateTask(@RequestBody Task updatedTask) {
		return taskToDoService.updateTask(updatedTask.getId(), updatedTask.getDesc());
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteCompletedTask() {
		taskToDoService.deleteCompletedTask();
	}
}
