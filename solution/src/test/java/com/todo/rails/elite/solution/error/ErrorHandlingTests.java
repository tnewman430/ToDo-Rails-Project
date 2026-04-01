package com.todo.rails.elite.solution.error;

import com.todo.rails.elite.solution.repository.TaskRepository;
import com.todo.rails.elite.solution.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


class ErrorHandlingTests {

	@Mock
	private TaskRepository taskRepository;

	@InjectMocks
	private TaskService taskService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void getTaskById_NotFound() {
		when(taskRepository.findById(1L)).thenReturn(Optional.empty());

		Exception exception = assertThrows(RuntimeException.class, () -> taskService.getTaskById(1L));

		assertEquals("Task not found", exception.getMessage());
	}
}
