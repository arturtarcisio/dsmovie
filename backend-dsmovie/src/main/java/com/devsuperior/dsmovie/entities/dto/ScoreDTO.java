package com.devsuperior.dsmovie.entities.dto;

import java.io.Serializable;

public class ScoreDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long movieId;	
	private String email;	
	private Double score;
	
	public ScoreDTO() {
		super();
	}

	public ScoreDTO(Long movieId, String email, Double score) {
		super();
		this.movieId = movieId;
		this.email = email;
		this.score = score;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieId == null) ? 0 : movieId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScoreDTO other = (ScoreDTO) obj;
		if (movieId == null) {
			if (other.movieId != null)
				return false;
		} else if (!movieId.equals(other.movieId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ScoreDTO [movieId=" + movieId + ", email=" + email + ", score=" + score + "]";
	}
	
	
	

}
