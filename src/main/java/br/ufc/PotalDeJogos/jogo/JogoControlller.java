package br.ufc.PotalDeJogos.jogo;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class JogoControlller {
	
	@Autowired
	JogoRepository jogoRepository;

	@PostMapping(value = "/jogo")
	@Transactional 
	public ResponseEntity<Object> addJogo(@RequestBody @Valid CadastraJogoRequest cadastraJogoRequest){

		boolean existsJogo = jogoRepository.existsByNome(cadastraJogoRequest.getNome());
		
		if(existsJogo) {
			return ResponseEntity.badRequest().build();
		} 
	
		
		Jogo jogo = cadastraJogoRequest.toModel();
		
		jogoRepository.save(jogo);
		
		return ResponseEntity.ok().body("Jogo cadastrado com sucesso.");
		
	}
	
	@DeleteMapping(value = "/jogo/{idJogo}")
	public ResponseEntity<Void> deletaJogo(@Valid @NotNull @PathVariable long idJogo) {
		
		Optional<Jogo> jogoOpt = jogoRepository.findById(idJogo);
		
		if(jogoOpt.isEmpty()) {
			
			 ResponseEntity.notFound().build();
			
		}
		
		jogoRepository.deleteById(idJogo);
		return ResponseEntity.noContent().build();
	}
	
}
