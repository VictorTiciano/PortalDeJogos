package br.ufc.PotalDeJogos.jogo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository  extends JpaRepository<Jogo, Long>{
	
	boolean existsByNome(String nome);
	
	Optional<Jogo> findByNome (String nome);

}
