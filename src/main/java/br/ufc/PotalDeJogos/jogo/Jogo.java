package br.ufc.PotalDeJogos.jogo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Jogo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@NotBlank
	String nome;
	
	@NotBlank
	String descricao;
	
	@NotBlank
	String dataLancamento;
	
	@NotBlank
	String linkLoja;
	
	@Deprecated
	public Jogo() {}

	public Jogo(@NotBlank String nome, @NotBlank String descricao, @NotBlank String dataLancamento,
			@NotBlank String linkLoja) {
		this.nome = nome;
		this.descricao = descricao;
		this.dataLancamento = dataLancamento;
		this.linkLoja = linkLoja;
	}

	
	
}
