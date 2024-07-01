package com.question.services;

import java.util.List;

import com.question.entity.Question;

public interface QuestionService {
	
	Question addQuestion(Question question);
	
	List<Question> getQuestions();
	
	Question getQuestion(Long questionId);
	
	Question deleteQuestion(Long questionId);
	
	List<Question> getQuestionsOfQuiz(long quizId);
}
