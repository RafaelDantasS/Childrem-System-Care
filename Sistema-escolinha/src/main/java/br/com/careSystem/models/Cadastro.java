package br.com.careSystem.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cadastro")
public class Cadastro implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "cadastro" , cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Responsavel> responsaveis;
	
	@OneToMany(mappedBy = "cadastro", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Crianca> criancas;
	
	public Long getId() {
		return id;
	}
	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}
	public List<Crianca> getCriancas() {
		return criancas;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}
	public void setCriancas(List<Crianca> criancas) {
		this.criancas = criancas;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(criancas, id, responsaveis);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadastro other = (Cadastro) obj;
		return Objects.equals(criancas, other.criancas) && Objects.equals(id, other.id)
				&& Objects.equals(responsaveis, other.responsaveis);
	}
	
	
}
