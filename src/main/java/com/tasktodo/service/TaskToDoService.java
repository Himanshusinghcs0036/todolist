package com.tasktodo.service;

import java.util.Map;

import com.tasktodo.model.Task;
import com.tasktodo.model.TaskResponseDto;

public interface TaskToDoService {

	TaskResponseDto addTask(String description);

	Map<String, Task> getTasks();

	String completeTask(String id);

	String updateTask(String id, String newDesc);

	void deleteCompletedTask();
}
