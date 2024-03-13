package br.com.careSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.careSystem.models.Cadastro;
@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long>{
	
}
