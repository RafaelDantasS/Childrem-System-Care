package br.com.careSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.careSystem.models.Cadastro;
import br.com.careSystem.models.Responsavel;
@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long>{
	@Query("SELECT r FROM Responsavel r WHERE r.cadastro = :cadastro")
	List<Responsavel> findAllByCadastro(@Param("cadastro")Cadastro cadastro);
}
