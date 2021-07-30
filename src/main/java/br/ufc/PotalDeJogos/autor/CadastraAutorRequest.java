package br.ufc.PotalDeJogos.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CadastraAutorRequest {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
	
	@Deprecated
	public CadastraAutorRequest() {}

	public CadastraAutorRequest(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String intagram,
			@NotBlank String twitter) {
		this.nome = nome;
		this.email = email;
		
	}
	

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email);
		
	}


}
