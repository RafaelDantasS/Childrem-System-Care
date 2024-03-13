package br.com.careSystem.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class Mapper {


	private static ModelMapper mapper = new ModelMapper();
	
	public  <O , D> D parseObject(O origin, Class<D> destinaiton) {
		
		return mapper.map(origin, destinaiton);
	}
	public  <O , D> List<D> parseListObject(List<O> origin, Class<D> destinaiton) {
		List<D> destinationObjects = new ArrayList<D>();
		for(O o : origin) {
			destinationObjects.add(mapper.map(o, destinaiton));
		}
		return destinationObjects;
	}
}
