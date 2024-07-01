package com.quiz.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String topic;
	
//	if we don’t want to save value of a particular variable in a file, then we use transient keyword
	transient private List<Question> questions;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public Quiz(long id, String topic) {
		super();
		this.id = id;
		this.topic = topic;
	}
	
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
//	public void setQuestions(List<Question> questions) {
//		this.questions = questions;
//	}
	public void setQuestions(List<Question> questionOfQuiz) {
		this.questions = questionOfQuiz;
		
	}
	
	
	
	
}
