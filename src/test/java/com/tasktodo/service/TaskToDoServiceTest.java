package com.tasktodo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tasktodo.model.Task;
import com.tasktodo.service.impl.TaskToDoServiceImpl;

public class TaskToDoServiceTest {

	private TaskToDoService taskToDoservice;

	@BeforeEach
	public void setUp() {
		taskToDoservice = new TaskToDoServiceImpl();
	}

	@Test
	public void testAddTaskBoundaryCases() {
		assertEquals(null, taskToDoservice.addTask(null));
		assertEquals(null, taskToDoservice.addTask(""));
	}

	@Test
	public void testAddTask() {
		String id = taskToDoservice.addTask("Task1");
		Task expected = new Task(id, "Task1", false);
		Task actual = taskToDoservice.getTasks().get(id);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetTasks() {
		String id1 = taskToDoservice.addTask("description1");
		String id2 = taskToDoservice.addTask("description2");
		taskToDoservice.addTask("");

		Task expected1 = new Task(id1, "description1", false);
		Task actual1 = taskToDoservice.getTasks().get(id1);
		Task expected2 = new Task(id2, "description2", false);
		Task actual2 = taskToDoservice.getTasks().get(id2);

		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
		assertEquals(2, taskToDoservice.getTasks().size());
	}

	@Test
	public void testCompleteTaskBoundaryCases() {
		assertEquals(null, taskToDoservice.completeTask(""));
		assertEquals(null, taskToDoservice.completeTask(null));
	}

	@Test
	public void testCompleteTask() {
		String id = taskToDoservice.addTask("description");
		taskToDoservice.completeTask(id);
		Task expected = new Task(id, "description", true);
		Task actual = taskToDoservice.getTasks().get(id);
		assertEquals(expected, actual);
	}

	@Test
	public void updateTaskBoundaryCases() {
		assertEquals(null, taskToDoservice.updateTask("id", null));
		assertEquals(null, taskToDoservice.updateTask("id", ""));
		assertEquals(null, taskToDoservice.updateTask("", "desc"));
		assertEquals(null, taskToDoservice.updateTask(null, "desc"));
	}

	@Test
	public void testUpdateTask() {
		String id = taskToDoservice.addTask("descriptionOld");
		taskToDoservice.updateTask(id, "descriptionNew");
		assertEquals("descriptionNew", taskToDoservice.getTasks().get(id).getDesc());
	}

	@Test
	public void testDeleteCompletedTasks() {
		String id = taskToDoservice.addTask("description");
		taskToDoservice.completeTask(id);
		taskToDoservice.deleteCompletedTask();
		assertEquals(null, taskToDoservice.getTasks().get(id));
	}
}
