package com.quiz.entity;

public class Question {
	private long questionId;
	private String question;
	
	private long quizId;
	
	
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public long getQuizId() {
		return quizId;
	}
	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}
	
	public Question(long questionId, String question, long quizId) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.quizId = quizId;
	}
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
