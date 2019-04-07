package com.tasktodo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.tasktodo.model.Task;
import com.tasktodo.model.TaskDto;
import com.tasktodo.model.TaskResponseDto;
import com.tasktodo.service.TaskToDoService;

@SpringBootTest
public class TaskToDoControllerTest {

	@InjectMocks
	private TaskToDoController taskToDoController;

	@Mock
	private TaskToDoService taskToDoService;

	@Test
	public void testAddTask() {
		TaskResponseDto expected = new TaskResponseDto("taskId");
		Mockito.when(taskToDoService.addTask("description")).thenReturn(expected);
		TaskResponseDto actual = taskToDoController.addTask(new TaskDto("description"));
		assertEquals(expected, actual);
	}

	@Test
	public void testGetTasks() {
		Map<String, Task> expected = getExpected();
		Mockito.when(taskToDoService.getTasks()).thenReturn(map());
		Map<String, Task> actual = taskToDoController.getTasks();
		assertEquals(expected, actual);
	}

	@Test
	public void testCompleteTask() {
		String expected = "taskId";
		Mockito.when(taskToDoService.completeTask("taskId")).thenReturn("taskId");
		String actual = taskToDoController.completeTask("taskId");
		assertEquals(expected, actual);
	}

	@Test
	public void testUpdateTask() {
		String expected = "taskId";
		Mockito.when(taskToDoService.updateTask("taskId", "newDesc")).thenReturn("taskId");
		String actual = taskToDoController.updateTask(new Task("taskId", "newDesc", false));
		assertEquals(expected, actual);
	}

	@Test
	public void testDeleteCompletedTask() {
		taskToDoController.deleteCompletedTask();
		Mockito.verify(taskToDoService).deleteCompletedTask();
	}

	private Map<String, Task> getExpected() {
		Map<String, Task> map = new HashMap<String, Task>();
		map.put("taskId", new Task("taskId", "desc", true));
		return map;
	}

	private Map<String, Task> map() {
		Map<String, Task> map = new HashMap<String, Task>();
		map.put("taskId", new Task("taskId", "desc", true));
		return map;
	}
}
