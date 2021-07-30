package br.ufc.PotalDeJogos.publicacao;

public class PublicacaoResponse {

	long id;
	
	String nome;

	public PublicacaoResponse(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	
	
}
