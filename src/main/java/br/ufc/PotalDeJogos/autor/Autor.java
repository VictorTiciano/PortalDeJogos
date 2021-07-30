package br.ufc.PotalDeJogos.autor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
	@Deprecated
	public Autor() {}

	public Autor(@NotBlank String nome, @NotBlank @Email String email) {
		this.nome = nome;
		this.email = email;
	}


}
