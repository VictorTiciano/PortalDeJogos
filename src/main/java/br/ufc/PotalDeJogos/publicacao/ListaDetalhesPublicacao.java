package br.ufc.PotalDeJogos.publicacao;

import javax.validation.constraints.NotBlank;

public class ListaDetalhesPublicacao {
	
	String titulo;
	
	String conteudo;

	public ListaDetalhesPublicacao(@NotBlank String titulo, @NotBlank String conteudo) {
		
		this.titulo = titulo;
		this.conteudo = conteudo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	
}
