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

import br.com.careSystem.dtos.CadastroDto;
import br.com.careSystem.dtos.CriancaDto;
import br.com.careSystem.dtos.ResponsavelDto;
import br.com.careSystem.services.CadastroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;



@RestController
@RequestMapping("/api/DepInfan/Cadastro")
public class CadastroController {
	
	@Autowired
	private CadastroService cad;
	
	@GetMapping(value = "/criancas/{id}")
	@Operation(summary = "findCriancasByRegister", description = "find criancas by cadastro"
		,tags = "Cadastro",
		responses = {
				@ApiResponse(description = "Sucess" ,responseCode = "200",
					content = @Content(mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = CriancaDto.class)))),
				@ApiResponse(description = "Bad request", responseCode= "400", content = @Content),
				@ApiResponse(description = "Anauthorized", responseCode= "401", content = @Content),
				@ApiResponse(description = "Not found", responseCode= "404", content = @Content),
				@ApiResponse(description = "Internal server error", responseCode= "500", content = @Content)})
	
	public List<CriancaDto> getAllCriancaById(@PathVariable(value = "id") Long id) {
		var dto = cad.findAllCriancasByCadastro(id);
		return dto; 
	}
	
	@GetMapping(value = "/responsaveis/{id}")
	@Operation(summary = "findResponsaveisByRegister", description = "find responsaveis by cadastro"
	,tags = "Cadastro",
	responses = {
			@ApiResponse(description = "Sucess" ,responseCode = "200",
				content = @Content(mediaType = "application/json",
						array = @ArraySchema(schema = @Schema(implementation = ResponsavelDto.class)))),
			@ApiResponse(description = "Bad request", responseCode= "400", content = @Content),
			@ApiResponse(description = "Anauthorized", responseCode= "401", content = @Content),
			@ApiResponse(description = "Not found", responseCode= "404", content = @Content),
			@ApiResponse(description = "Internal server error", responseCode= "500", content = @Content)})
	public List<ResponsavelDto> getAllResponsaveisById(@PathVariable(value = "id") Long id) {
		var dto = cad.findAllResponsaveisByCadastro(id);
		return dto; 
	}
	
	@GetMapping(value = "/{id}")
	@Operation(summary = "findById", description = "find cadastro by Identity",
	tags = "Cadastro",
	responses = {
			@ApiResponse(description = "Sucess" ,responseCode = "200",
				content = @Content(mediaType = "application/json",
						schema = @Schema(implementation = CadastroDto.class))),
			@ApiResponse(description = "Bad request", responseCode= "400", content = @Content),
			@ApiResponse(description = "No Content", responseCode= "204", content = @Content),
			@ApiResponse(description = "Anauthorized", responseCode= "401", content = @Content),
			@ApiResponse(description = "Not found", responseCode= "404", content = @Content),
			@ApiResponse(description = "Internal server error", responseCode= "500", content = @Content)})
	public CadastroDto getById(@PathVariable(value = "id") Long id) {
		var dto = cad.findById(id);
		return dto; 
	}
	
	@GetMapping
	@Operation(summary = "findAllCadastro", description = "find all cadastro"
	,tags = "Cadastro",
	responses = {
			@ApiResponse(description = "Sucess" ,responseCode = "200",
				content = @Content(mediaType = "application/json",
						array = @ArraySchema(schema = @Schema(implementation = CadastroDto.class)))),
			@ApiResponse(description = "Bad request", responseCode= "400", content = @Content),
			@ApiResponse(description = "Anauthorized", responseCode= "401", content = @Content),
			@ApiResponse(description = "Not found", responseCode= "404", content = @Content),
			@ApiResponse(description = "Internal server error", responseCode= "500", content = @Content)})
	public List<CadastroDto> getAll(){
		
		return cad.findAll();
	}
	
	@PostMapping
	@Operation(summary = "Create", description = "create cadastro"
	,tags = "Cadastro",
	responses = {
			@ApiResponse(description = "Success", responseCode= "200", 
					content = 
						@Content(schema = @Schema(implementation = CadastroDto.class))),
			@ApiResponse(description = "Bad request", responseCode= "400", content = @Content),
			@ApiResponse(description = "Anauthorized", responseCode= "401", content = @Content),
			@ApiResponse(description = "Internal server error", responseCode= "500", content = @Content)
			})
	public CadastroDto save(@RequestBody CadastroDto cadastroDto) {
		
		var dto = cad.save(cadastroDto);
		return dto;
	}
	
	@PutMapping
	@Operation(summary = "update", description = "Update the Cadastro data by Id",
	tags = "Cadastro",
			responses = {
					@ApiResponse(description = "Success", responseCode= "200", 
							content = 
								@Content(schema = @Schema(implementation = CadastroDto.class))),
					@ApiResponse(description = "Bad request", responseCode= "400", content = @Content),
					@ApiResponse(description = "Anauthorized", responseCode= "401", content = @Content),
					@ApiResponse(description = "Not found", responseCode= "404", content = @Content),
					@ApiResponse(description = "Internal server error", responseCode= "500", content = @Content)
	})
	public CadastroDto update(@RequestBody CadastroDto cadastroDto) {
		
		var dto = cad.update(cadastroDto);
		return dto;
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "delete", description = "delete a cadastro",
	tags = "Cadastro",
			responses = {
					@ApiResponse(description = "Success", responseCode= "200", 
							content = 
								@Content(schema = @Schema(implementation = CadastroDto.class))),
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
