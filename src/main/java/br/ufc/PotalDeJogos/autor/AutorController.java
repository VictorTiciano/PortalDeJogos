package br.ufc.PotalDeJogos.autor;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutorController {
	
	@Autowired
	AutorRepository autorRepository;
	
	@PostMapping(value = "/autor")
	@Transactional 
	public ResponseEntity<Object> addAutor(@RequestBody @Valid CadastraAutorRequest cadastraAutorRequest){
		
		boolean existsAutor = autorRepository.existsByEmail(cadastraAutorRequest.getEmail());
		
		if(existsAutor) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao inserir usuário.");
		}
		
		Autor autor = cadastraAutorRequest.toModel();
		
		autorRepository.save(autor);
		
		return ResponseEntity.created(null).body("Autor cadastrado com sucesso.");
		
	}
	
	@DeleteMapping(value = "/autor/{idautor}")
	public ResponseEntity<Void> deletaAutor(@Valid @NotNull @PathVariable long idautor) {
		
		Optional<Autor> autorOpt = autorRepository.findById(idautor);
		
		if(autorOpt.isEmpty()) {
			
			 ResponseEntity.notFound().build();
			
		}
		
		autorRepository.deleteById(idautor);
		return ResponseEntity.noContent().build();
	}

}
