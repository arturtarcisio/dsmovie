package com.devsuperior.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.entities.dto.MovieDTO;
import com.devsuperior.dsmovie.services.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping
	public ResponseEntity<Page<MovieDTO>> findAll (Pageable pageable) {
		return ResponseEntity.ok(movieService.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> findById (@PathVariable Long id) {
		return ResponseEntity.ok(movieService.findMovie(id));
	}

}
