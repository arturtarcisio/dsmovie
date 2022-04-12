package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.entities.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.dto.ScoreDTO;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;



@Service
public class ScoreService {
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		var user = userRepository.findByEmail(dto.getEmail());
		var score = new Score();
		var movie = new Movie();
		var optionalMovie = movieRepository.findById(dto.getMovieId());
		
		if (optionalMovie.isPresent()) {
			movie = optionalMovie.get();
		}
		
		var listSize = movie.getScores().size();		
		
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}		
		
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum += s.getValue();
		}
		
		double avg = sum / listSize;
		
		movie.setScore(avg);
		movie.setCount(listSize);
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}

}
