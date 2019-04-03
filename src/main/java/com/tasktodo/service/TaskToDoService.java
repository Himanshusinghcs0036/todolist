package com.tasktodo.service;

import java.util.Map;

import com.tasktodo.model.Task;

public interface TaskToDoService {

	String addTask(String description);

	Map<String, Task> getTasks();

	String completeTask(String id);

	String updateTask(String id, String newDesc);

	void deleteCompletedTask();
}
