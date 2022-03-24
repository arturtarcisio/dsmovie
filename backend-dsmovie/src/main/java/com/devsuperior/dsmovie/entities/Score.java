package com.devsuperior.dsmovie.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_score")
public class Score implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ScorePK scorePK = new ScorePK();
	
	private Double value;
	
	private void setMovie(Movie movie) {
		scorePK.setMovie(movie);
	}
	
	private void setUser(User user) {
		scorePK.setUser(user);
	}

}
