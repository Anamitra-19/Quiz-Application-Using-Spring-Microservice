package com.question.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entity.Question;
import com.question.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	//create question
	@PostMapping
	public Question addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
	
	//Get all the questions
	@GetMapping
	public List<Question> getQuestions(){
		return questionService.getQuestions();
	}
	
	//Get question with id
	@GetMapping("/{questionId}")
	public Question getQuestion(@PathVariable long questionId) {
		return questionService.getQuestion(questionId);
	}
	
	//Delete question by questionId
	@DeleteMapping("/{questionId}")
	public Question deleteQuestion(@PathVariable long questionId) {
		return questionService.deleteQuestion(questionId);
	}
	
	//get all questions of specific quiz
		@GetMapping("/quiz/{quizId}")
		public List<Question> getQuestionsOfQuiz(@PathVariable long quizId){
			return questionService.getQuestionsOfQuiz(quizId);
		}
}
