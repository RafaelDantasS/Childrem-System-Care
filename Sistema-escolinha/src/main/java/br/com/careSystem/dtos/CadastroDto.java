package br.com.careSystem.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import br.com.careSystem.models.Crianca;
import br.com.careSystem.models.Responsavel;

public class CadastroDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private List<Responsavel> responsaveis;
	
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
		CadastroDto other = (CadastroDto) obj;
		return Objects.equals(criancas, other.criancas) && Objects.equals(id, other.id)
				&& Objects.equals(responsaveis, other.responsaveis);
	}
	
	
}
