package br.com.api.tweet.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.api.tweet.modelo.Tweet;
import br.com.api.tweet.repository.TweetRepository;


@RestController
@RequestMapping("/tweets")
public class TweetController {
	
	@Autowired
	private TweetRepository tweetRepository;

	@GetMapping
	public List<Tweet> get() {
		List<Tweet> tweets = tweetRepository.findAll();
		return tweets;
	}
	
	@GetMapping("/{id}")
	public Tweet get(@PathVariable int id) {
		Tweet tweet = tweetRepository.findById(id).get();
		return tweet;
	}
	
	@PostMapping
	public ResponseEntity<Tweet> create(@RequestBody Tweet tweet, UriComponentsBuilder uriBuilder) {
		tweetRepository.save(tweet);
		URI uri = uriBuilder.path("/tweet/{id}").buildAndExpand(tweet.getId()).toUri();
		return ResponseEntity.created(uri).body(tweet);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Tweet> update(@PathVariable int id, @RequestBody Tweet tweet) {
		Tweet updatetweet = tweetRepository.findById(id).get();
		updatetweet.setCategoria(tweet.getCategoria());
		updatetweet.setMensagem(tweet.getMensagem());
		tweetRepository.save(updatetweet);

		return ResponseEntity.ok(updatetweet);
	}
}
