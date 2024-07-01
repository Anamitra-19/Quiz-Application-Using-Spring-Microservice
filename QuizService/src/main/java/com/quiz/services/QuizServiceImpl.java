package com.quiz.services;

import java.util.List;

import java.util.stream.Collectors; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entity.Quiz;
import com.quiz.repository.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizRepository quizRepo;
	
	@Autowired
	private QuestionClient questionClient;
	
	@Override
	public Quiz add(Quiz quiz) {
		quizRepo.save(quiz);
		return quiz;
	}

	@Override
	public List<Quiz> get() {
		List<Quiz> quizzes = quizRepo.findAll();
		List<Quiz> newQuizList = quizzes.stream().map(quiz->{
			quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		
		return newQuizList;
	}

	@Override
	public Quiz get(Long id) {
		Quiz quiz = quizRepo.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found"));
		quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
	}

	@Override
	public Quiz delete(long id) {
		Quiz quiz = quizRepo.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found"));
		quizRepo.deleteById(id);
		return quiz;
	}
	

}
