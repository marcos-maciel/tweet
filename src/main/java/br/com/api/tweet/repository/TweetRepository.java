package br.com.api.tweet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.tweet.modelo.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Number> {
	
}
