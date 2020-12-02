package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

import javafx.scene.control.Label;

public class Task {
	
	public static Task TASKCLIPBOARD;
	
	private String name;
	private String subject;
	private String description;
	private LocalDate date;
	
	public Task(String name, String subject, String description, LocalDate date) {
		setName(name);
		setSubject(subject);
		setDescription(description);
		setDate(date);
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getDescription() {
		return description;
	}
	
	public LocalDate getDate() {
		return date;
	}

}
