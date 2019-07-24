package com.tasktodo.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tasktodo.exception.ErrorCode;
import com.tasktodo.exception.InvalidDataException;
import com.tasktodo.model.Task;
import com.tasktodo.model.TaskResponseDto;
import com.tasktodo.service.TaskToDoService;

@Service
public class TaskToDoServiceImpl implements TaskToDoService {

	private Map<String, Task> map = new HashMap<String, Task>();

	@Override
	public TaskResponseDto addTask(String description) {
		if (description == null || description.equals(""))
			throw new InvalidDataException(ErrorCode.INVALID_DESCRIPTION);
		String id = UUID.randomUUID().toString();
		map.put(id, new Task(id, description, false));
		return new TaskResponseDto(id);
	}

	@Override
	public Map<String, Task> getTasks() {
		return map;
	}

	@Override
	public String completeTask(String id) {
		if (id == null || id.equals(""))
			throw new InvalidDataException(ErrorCode.INVALID_ID);
		Task inCompletedTask = getTasks().get(id);
		Task completedTask = new Task(id, inCompletedTask.getDesc(), true);
		map.put(id, completedTask);
		return id;
	}

	@Override
	public String updateTask(String id, String newDesc) {
		if (id == null || id.equals("") || newDesc == null || newDesc.equals(""))
			throw new InvalidDataException(ErrorCode.INVALID_ID_OR_DESCRIPTION);
		Task oldTask = getTasks().get(id);
		Task updatedTask = new Task(id, newDesc, oldTask.isCompleted());
		map.put(id, updatedTask);
		return id;
	}

	@Override
	public void deleteCompletedTask() {
		map = map.entrySet().stream().map(entry -> entry.getValue()).filter(task -> !task.isCompleted())
				.collect(Collectors.toMap(task -> task.getId(), task -> task));
	}
}
