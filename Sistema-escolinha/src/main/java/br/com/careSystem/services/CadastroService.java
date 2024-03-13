package br.com.careSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.careSystem.dtos.CadastroDto;
import br.com.careSystem.dtos.CriancaDto;
import br.com.careSystem.dtos.ResponsavelDto;
import br.com.careSystem.exceptions.ResourceNotFoundEXception;
import br.com.careSystem.mapper.Mapper;
import br.com.careSystem.models.Cadastro;
import br.com.careSystem.repository.CadastroRepository;
import br.com.careSystem.repository.CriancaRepository;
import br.com.careSystem.repository.ResponsavelRepository;

@Service
public class CadastroService {
	@Autowired
	private CadastroRepository repo;
	@Autowired
	private CriancaRepository criancaRepository;
	@Autowired
	private ResponsavelRepository responsavelRepository;
	@Autowired
	private Mapper map;
	
	public List<CadastroDto> findAll(){
		var dto = map.parseListObject(repo.findAll(), CadastroDto.class);
		return dto;
	}
	
	public CadastroDto findById(Long id) {
		
		var dto = map.parseObject(repo.findById(id), CadastroDto.class);
		return dto;
	}
	
	public CadastroDto save(CadastroDto cadastro) {
		
		var entity = map.parseObject(cadastro, Cadastro.class);
		var dto = map.parseObject(repo.save(entity), CadastroDto.class);
		
		return dto;
	}
	
	public CadastroDto update(CadastroDto cadastro) {
		var entity = repo.findById(cadastro.getId()).orElseThrow(() -> new ResourceNotFoundEXception("No records found for this name.")) ;
		entity.setCriancas(cadastro.getCriancas());
		entity.setResponsaveis(cadastro.getResponsaveis());
		var dto = map.parseObject(entity, CadastroDto.class);
		return dto;
	}
	
	public void delete(Long id) {
		var entity = repo.findById(id).orElseThrow(() -> new ResourceNotFoundEXception("No records found for this name."));
		repo.delete(entity);
	}
	
	public List<CriancaDto> findAllCriancasByCadastro(Long id){
		var entity = repo.findById(id).orElseThrow(() -> new ResourceNotFoundEXception("No records found for this name."));
		var dto = map.parseListObject(criancaRepository.findAllByCadastro(entity), CriancaDto.class);
		return dto;
		
	}
	public List<ResponsavelDto> findAllResponsaveisByCadastro(Long id){
		var entity = repo.findById(id).orElseThrow(() -> new ResourceNotFoundEXception("No records found for this name."));
		var dto = map.parseListObject(responsavelRepository.findAllByCadastro(entity), ResponsavelDto.class);
		return dto;
	}
}
