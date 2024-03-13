package br.com.careSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.careSystem.models.Cadastro;
import br.com.careSystem.models.Crianca;
@Repository
public interface CriancaRepository extends JpaRepository<Crianca, Long>{
	@Query("SELECT c FROM Crianca c WHERE c.cadastro = :cadastro")
	List<Crianca> findAllByCadastro(@Param("cadastro")Cadastro cadastro);
}
