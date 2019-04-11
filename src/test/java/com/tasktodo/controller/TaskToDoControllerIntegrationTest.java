package com.tasktodo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tasktodo.TaskToDoApplication;
import com.tasktodo.model.TaskDto;

@SpringBootTest(classes = TaskToDoApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class TaskToDoControllerIntegrationTest {

	@LocalServerPort
	private int port;

	private TestRestTemplate restTemplate = new TestRestTemplate();

	private HttpHeaders headers = new HttpHeaders();

	@Test
	public void testAddTasks() {
		TaskDto dto = new TaskDto("desc");
		ResponseEntity<String> response = getResponse(dto, "/tasks", HttpMethod.POST);
		HttpStatus expected = HttpStatus.CREATED;
		HttpStatus actual = response.getStatusCode();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetTasks() {
		ResponseEntity<String> response = getResponse(null, "/tasks", HttpMethod.GET);
		HttpStatus actual = response.getStatusCode();
		HttpStatus expected = HttpStatus.OK;
		assertEquals(expected, actual);
	}

	private ResponseEntity<String> getResponse(TaskDto dto, String uri, HttpMethod method) {
		HttpEntity<TaskDto> entity = new HttpEntity<TaskDto>(dto, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(uri), method, entity, String.class);
		return response;
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
