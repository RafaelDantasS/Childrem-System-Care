package br.com.careSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.careSystem.dtos.ResponsavelDto;
import br.com.careSystem.exceptions.ResourceNotFoundEXception;
import br.com.careSystem.mapper.Mapper;
import br.com.careSystem.models.Responsavel;
import br.com.careSystem.repository.ResponsavelRepository;
@Service
public class ResponsavelService {

	@Autowired
	private Mapper map;
	@Autowired
	private ResponsavelRepository repo;
	
	public List<ResponsavelDto> findAll(){
		var dto = map.parseListObject(repo.findAll(), ResponsavelDto.class);
		return dto;
	}
	
	public ResponsavelDto findById(Long id) {
		
		var dto = map.parseObject(repo.findById(id), ResponsavelDto.class);
		return dto;
	}
	
	public ResponsavelDto save(ResponsavelDto Responsavel) {
		
		var entity = map.parseObject(Responsavel, Responsavel.class);
		var dto = map.parseObject(repo.save(entity), ResponsavelDto.class);
		
		return dto;
	}
	
	public ResponsavelDto update(ResponsavelDto Responsavel) {
		var entity = repo.findById(Responsavel.getId()).orElseThrow(() -> new ResourceNotFoundEXception("No records found for this name.")) ;
		var dto = map.parseObject(entity, ResponsavelDto.class);
		return dto;
	}
	
	public void delete(Long id) {
		var entity = repo.findById(id).orElseThrow(() -> new ResourceNotFoundEXception("No records found for this name."));
		repo.delete(entity);
	}
	
}
