package com.question.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.question.entity.Question;
import com.question.repositories.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionRepository questionRepository;
	
	
	@Override
	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}
	
	@Override
	public List<Question> getQuestions() {
		return questionRepository.findAll();
	}
	

	@Override
	public Question getQuestion(Long questionId) {
		return questionRepository.findById(questionId).orElseThrow(()-> new RuntimeException("No questions find"));
	}

	
	@Override
	public Question deleteQuestion(Long questionId) {
		Question question = questionRepository.findById(questionId).orElseThrow(()-> new RuntimeException("No questions find"));
		questionRepository.deleteById(questionId);
		return question;
	}


	@Override
	public List<Question> getQuestionsOfQuiz(long quizId) {
		return questionRepository.findByQuizId(quizId);
	}
	

}
