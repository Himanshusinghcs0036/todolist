package com.tasktodo.model;

public class TaskResponseDto {

	private String taskId;

	public TaskResponseDto(String taskId) {
		super();
		this.taskId = taskId;
	}

	public String getTaskId() {
		return taskId;
	}
}
