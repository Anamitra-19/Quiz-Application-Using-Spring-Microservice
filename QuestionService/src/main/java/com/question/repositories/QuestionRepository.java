package com.question.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.question.entity.Question;

public interface QuestionRepository extends JpaRepository<Question,Long>{

	//method name should be "findBy<variableName>"
	List<Question> findByQuizId(long quizId);
}
