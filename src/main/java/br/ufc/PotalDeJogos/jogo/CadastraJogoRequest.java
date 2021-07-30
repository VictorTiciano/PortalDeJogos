package br.ufc.PotalDeJogos.jogo;

import javax.validation.constraints.NotBlank;

public class CadastraJogoRequest {
	
	@NotBlank
	String nome;
	
	@NotBlank
	String descricao;
	
	@NotBlank
	String dataLancamento;
	
	@NotBlank
	String linkLoja;

	public CadastraJogoRequest(@NotBlank String nome, @NotBlank String descricao, @NotBlank String dataLancamento,
			@NotBlank String linkLoja) {
		this.nome = nome;
		this.descricao = descricao;
		this.dataLancamento = dataLancamento;
		this.linkLoja = linkLoja;
	}

	public Jogo toModel() {
		return new Jogo(this.nome,this.descricao,this.dataLancamento,this.linkLoja);
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public String getLinkLoja() {
		return linkLoja;
	}
	
}
