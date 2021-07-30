package br.ufc.PotalDeJogos.publicacao;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import br.ufc.PotalDeJogos.autor.Autor;
import br.ufc.PotalDeJogos.jogo.Jogo;


@Entity
public class Publicacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	
	@NotBlank
	@Column(unique = true)
	String titulo;
	
	@NotBlank
	String conteudo;
	
	@PastOrPresent
	LocalDateTime dataPublicacao = LocalDateTime.now();
	
	@NotNull
	@ManyToOne
	Autor autor;
	
	@NotNull
	@ManyToOne 
	Jogo jogo;
	
	@Deprecated
	public Publicacao() {}

	public Publicacao(@NotBlank String titulo, @NotBlank String conteudo, @PastOrPresent LocalDateTime dataPublicacao,
			@NotNull Autor autor, @NotNull Jogo jogo) {
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.jogo = jogo;
	}

	public Publicacao(long id2, @NotBlank String titulo2, @NotBlank String conteudo2,
			@PastOrPresent LocalDateTime dataPublicacao2, Autor autor2, Jogo jogo2) {
		this.id = id2;
		this.titulo = titulo2;
		this.conteudo = conteudo2;
		this.dataPublicacao = dataPublicacao2;
		this.autor = autor2;
		this.jogo = jogo2;
		
	}

}
