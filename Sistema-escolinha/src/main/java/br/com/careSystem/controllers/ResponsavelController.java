package br.com.careSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.careSystem.dtos.ResponsavelDto;
import br.com.careSystem.services.ResponsavelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/DepInfan/responsavel")
public class ResponsavelController {

	@Autowired
	private ResponsavelService cad;
	
	@GetMapping(value = "/{id}")
	@Operation(summary = "findById", description = "find responsavel by Identity",
	tags = "Responsavel",
	responses = {
			@ApiResponse(description = "Sucess" ,responseCode = "200",
				content = @Content(mediaType = "application/json",
						schema = @Schema(implementation = ResponsavelDto.class))),
			@ApiResponse(description = "Bad request", responseCode= "400", content = @Content),
			@ApiResponse(description = "No Content", responseCode= "204", content = @Content),
			@ApiResponse(description = "Anauthorized", responseCode= "401", content = @Content),
			@ApiResponse(description = "Not found", responseCode= "404", content = @Content),
			@ApiResponse(description = "Internal server error", responseCode= "500", content = @Content)})
	public ResponsavelDto getById(@PathVariable(value = "id") Long id) {
		var dto = cad.findById(id);
		return dto; 
	}
	
	@GetMapping
	@Operation(summary = "findAllResponsavel", description = "find all responsaveis"
	,tags = "Responsavel",
	responses = {
			@ApiResponse(description = "Sucess" ,responseCode = "200",
				content = @Content(mediaType = "application/json",
						array = @ArraySchema(schema = @Schema(implementation = ResponsavelDto.class)))),
			@ApiResponse(description = "Bad request", responseCode= "400", content = @Content),
			@ApiResponse(description = "Anauthorized", responseCode= "401", content = @Content),
			@ApiResponse(description = "Not found", responseCode= "404", content = @Content),
			@ApiResponse(description = "Internal server error", responseCode= "500", content = @Content)})
	public List<ResponsavelDto> getAll(){
		
		return cad.findAll();
	}
	
	@PostMapping
	@Operation(summary = "Create", description = "create responsavel"
	,tags = "Responsavel",
	responses = {
			@ApiResponse(description = "Success", responseCode= "200", 
					content = 
						@Content(schema = @Schema(implementation = ResponsavelDto.class))),
			@ApiResponse(description = "Bad request", responseCode= "400", content = @Content),
			@ApiResponse(description = "Anauthorized", responseCode= "401", content = @Content),
			@ApiResponse(description = "Internal server error", responseCode= "500", content = @Content)
			})
	public ResponsavelDto save(@RequestBody ResponsavelDto ResponsavelDto) {
		
		var dto = cad.save(ResponsavelDto);
		return dto;
	}
	
	@PutMapping
	@Operation(summary = "update", description = "Update the responsavel data by Id",
	tags = "Responsavel",
			responses = {
					@ApiResponse(description = "Success", responseCode= "200", 
							content = 
								@Content(schema = @Schema(implementation = ResponsavelDto.class))),
					@ApiResponse(description = "Bad request", responseCode= "400", content = @Content),
					@ApiResponse(description = "Anauthorized", responseCode= "401", content = @Content),
					@ApiResponse(description = "Not found", responseCode= "404", content = @Content),
					@ApiResponse(description = "Internal server error", responseCode= "500", content = @Content)
	})
	public ResponsavelDto update(@RequestBody ResponsavelDto ResponsavelDto) {
		
		var dto = cad.update(ResponsavelDto);
		return dto;
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "delete", description = "delete a responsavel",
	tags = "Responsavel",
			responses = {
					@ApiResponse(description = "Success", responseCode= "200", 
							content = 
								@Content(schema = @Schema(implementation = ResponsavelDto.class))),
					@ApiResponse(description = "Bad request", responseCode= "400", content = @Content),
					@ApiResponse(description = "Anauthorized", responseCode= "401", content = @Content),
					@ApiResponse(description = "Not found", responseCode= "404", content = @Content),
					@ApiResponse(description = "Internal server error", responseCode= "500", content = @Content)
	})
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		cad.delete(id);
		return ResponseEntity.noContent().build();
	}
}
