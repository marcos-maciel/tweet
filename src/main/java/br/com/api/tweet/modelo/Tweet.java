package br.com.api.tweet.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.api.tweet.repository.TweetRepository;

@Entity
public class Tweet {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mensagem;
	private String categoria;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public Tweet update(int id, TweetRepository tweetRepository) {
		Tweet tweet = tweetRepository.findById(id).get();
		tweet.setCategoria(this.categoria);
		tweet.setMensagem(this.mensagem);
		
		return tweet;
	}

}
