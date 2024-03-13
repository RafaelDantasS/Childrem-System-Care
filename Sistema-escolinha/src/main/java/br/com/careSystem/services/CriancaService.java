package br.com.careSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.careSystem.dtos.CriancaDto;
import br.com.careSystem.exceptions.ResourceNotFoundEXception;
import br.com.careSystem.mapper.Mapper;
import br.com.careSystem.models.Crianca;
import br.com.careSystem.repository.CriancaRepository;

@Service
public class CriancaService {
	@Autowired
	private Mapper map;
	@Autowired
	private CriancaRepository repo;
	
	public List<CriancaDto> findAll(){
		var dto = map.parseListObject(repo.findAll(), CriancaDto.class);
		return dto;
	}
	
	public CriancaDto findById(Long id) {
		
		var dto = map.parseObject(repo.findById(id), CriancaDto.class);
		return dto;
	}
	
	public CriancaDto save(CriancaDto Crianca) {
		
		var entity = map.parseObject(Crianca, Crianca.class);
		var dto = map.parseObject(repo.save(entity), CriancaDto.class);
		
		return dto;
	}
	
	public CriancaDto update(CriancaDto Crianca) {
		var entity = repo.findById(Crianca.getId()).orElseThrow(() -> new ResourceNotFoundEXception("No records found for this name.")) ;
		var dto = map.parseObject(entity, CriancaDto.class);
		return dto;
	}
	
	public void delete(Long id) {
		var entity = repo.findById(id).orElseThrow(() -> new ResourceNotFoundEXception("No records found for this name."));
		repo.delete(entity);
	}
}
