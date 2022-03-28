package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.entities.dto.MovieDTO;
import com.devsuperior.dsmovie.repositories.MovieRepository;



@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		return movieRepository
				.findAll(pageable)
				.map(MovieDTO::new);			
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findMovie (Long id) {		
		return new MovieDTO(movieRepository.findById(id).get());
	}

}
