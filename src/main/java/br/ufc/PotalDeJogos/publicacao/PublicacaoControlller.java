package br.ufc.PotalDeJogos.publicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.PotalDeJogos.autor.Autor;
import br.ufc.PotalDeJogos.autor.AutorRepository;
import br.ufc.PotalDeJogos.jogo.Jogo;
import br.ufc.PotalDeJogos.jogo.JogoRepository;


@RestController
public class PublicacaoControlller {
	
	@Autowired
	JogoRepository jogorepositiry;
	
	@Autowired
	AutorRepository autorrepositiry;
	
	@Autowired
	PublicacaoRepository publicacaorepositiry;
	
	@PostMapping(value = "/publicacao")
	@Transactional
	public ResponseEntity<Object> addPublicacao(@RequestBody @Valid CadastraPublicacaoRequest cadastraPublicacaoRequest) {
		
		Optional<Jogo> jogoOpt = jogorepositiry.findByNome(cadastraPublicacaoRequest.getNomeJogo());
		
		if(jogoOpt.isEmpty()) {
			return ResponseEntity.badRequest().body("Jogo inválida"); 
		}
		
		Optional<Autor> autorOpt =	autorrepositiry.findByEmail(cadastraPublicacaoRequest.getEmailAutor());
		
		if(autorOpt.isEmpty()) {
			return ResponseEntity.badRequest().body("Autor inválida"); 
		}
		
		Publicacao publicacao = cadastraPublicacaoRequest.toModel(jogoOpt.get(), autorOpt.get());
		
		publicacaorepositiry.save(publicacao);
		
		return ResponseEntity.ok().body("Publicação criada com sucesso");
		
	}
	
	@GetMapping(value = "/publicacoes")
	public List<PublicacaoResponse> listaPublicacao(){
		
		List<PublicacaoResponse> publicacoesResponse = new  ArrayList<>();
		
		List<Publicacao> publicacoesFromdb = publicacaorepositiry.findAll();
		
		if(publicacoesFromdb.isEmpty()) {
			return null;
		}
		
		for (Publicacao publicacao : publicacoesFromdb) {
			
			publicacoesResponse.add(new PublicacaoResponse(publicacao.id, publicacao.titulo));
			
		}
		
		return publicacoesResponse;
	}
	
	@GetMapping(value = "/publicacoes/{idPublicacao}")
	public ResponseEntity<Object> detalhesPublicacao(@Valid @NotNull @PathVariable long idPublicacao){
		
		Optional<Publicacao> publicacaoOpt = publicacaorepositiry.findById(idPublicacao);
		
		if(publicacaoOpt.isEmpty()) {
			
			ResponseEntity.notFound().build();
			
		}
		
		Publicacao publicacaoFromDb = publicacaoOpt.get();
		
		ListaDetalhesPublicacao DetalhesPublicacao = new ListaDetalhesPublicacao(publicacaoFromDb.titulo, publicacaoFromDb.conteudo);
		
		return ResponseEntity.ok(DetalhesPublicacao);
	}
	
	@DeleteMapping(value = "/publicacao/{idPublicacao}")
	public ResponseEntity<Void> deletaPublicacao(@Valid @NotNull @PathVariable long idPublicacao) {
		
		Optional<Publicacao> publicacaoOpt = publicacaorepositiry.findById(idPublicacao);
		
		if(publicacaoOpt.isEmpty()) {
			
			 ResponseEntity.notFound().build();
			
		}
		
		publicacaorepositiry.deleteById(idPublicacao);
		return ResponseEntity.noContent().build();
	}
	
}
