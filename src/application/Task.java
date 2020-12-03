package application;

import java.time.LocalDate;

public class Task {
	
	public static Task TASKCLIPBOARD;
	
	private String name;
	private String description;
	private LocalDate date;
	
	public Task(String name, String description, LocalDate date) {
		setName(name);
		setDescription(description);
		setDate(date);
	}
	
	
	public void setName(String name) {
		this.name = name;
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
	
	public String getDescription() {
		return description;
	}
	
	public LocalDate getDate() {
		return date;
	}

}
