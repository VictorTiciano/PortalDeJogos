package br.ufc.PotalDeJogos.publicacao;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import br.ufc.PotalDeJogos.autor.Autor;
import br.ufc.PotalDeJogos.jogo.Jogo;

public class CadastraPublicacaoRequest {
	
	
	@NotBlank
	@Column(unique = true)
	String titulo;
	
	@NotBlank
	String conteudo;
	
	@PastOrPresent
	LocalDateTime dataPublicacao = LocalDateTime.now();
	
	@NotBlank
	String emailAutor;
	
	@NotBlank
	String nomeJogo;

	
	@Deprecated
	public CadastraPublicacaoRequest() {}

	
	
	public CadastraPublicacaoRequest(@NotBlank String titulo, @NotBlank String conteudo,
			@PastOrPresent LocalDateTime dataPublicacao, @NotBlank String emailAutor, @NotBlank String nomeJogo) {
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.dataPublicacao = dataPublicacao;
		this.emailAutor = emailAutor;
		this.nomeJogo = nomeJogo;
	}


	public String getTitulo() {
		return titulo;
	}



	public String getConteudo() {
		return conteudo;
	}



	public LocalDateTime getDataPublicacao() {
		return dataPublicacao;
	}



	public String getEmailAutor() {
		return emailAutor;
	}



	public String getNomeJogo() {
		return nomeJogo;
	}


	public Publicacao toModel(Jogo jogo, Autor autor) {

		return new Publicacao(this.titulo, this.conteudo, this.dataPublicacao, autor, jogo);
	}


}
