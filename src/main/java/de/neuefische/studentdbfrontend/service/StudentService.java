package de.neuefische.studentdbfrontend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.neuefische.studentdbfrontend.model.Student;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StudentService {

	private final HttpClient httpClient;
	private final ObjectMapper objectMapper;

	public StudentService() {
		this.httpClient = HttpClient.newHttpClient();
		this.objectMapper = new ObjectMapper();
	}

	public Student getStudentByMatriculationNumber(String matriculationNumber) {
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create("http://localhost:8080/api/students/" + matriculationNumber))
				.build();

		return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenApply(this::mapToStudent) // .thenApply(responseBody -> mapToStudent(responseBody))
				.join();
	}

	private Student mapToStudent(String json) {
		try {
			return objectMapper.readValue(json, Student.class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Failed to map student", e);
		}
	}

}
