package br.com.api.tweet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.api.tweet.modelo.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Number> {
	
	@Query("SELECT t FROM Tweet t WHERE t.categoria IS NOT NULL")
	List<Tweet> getTweetWithCategorie();
	
	@Query("SELECT t FROM Tweet t WHERE t.categoria IS NULL")
	List<Tweet> getTweetWithoutCategorie();
}
